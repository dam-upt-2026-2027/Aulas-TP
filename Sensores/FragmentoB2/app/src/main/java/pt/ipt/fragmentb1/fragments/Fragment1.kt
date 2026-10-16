package pt.ipt.fragmentb1.fragments

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import pt.ipt.fragmentb1.MainActivity
import pt.ipt.fragmentb1.R


/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1(private val parent: MainActivity) : Fragment(), LocationListener {
    private lateinit var locationManager: LocationManager
    private lateinit var view:View
    private lateinit var tvGpsLocation: TextView
    private val locationPermissionCode = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_1, container, false)
        val button: Button = view.findViewById(R.id.getLocation)
        button.setOnClickListener {
            getLocation()
        }
        return view;
    }

    private fun getLocation() {
        locationManager = parent.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(parent,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            requestPermissions( arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)

    }

    override fun onLocationChanged(location: Location) {
        tvGpsLocation = view.findViewById(R.id.textView)
        tvGpsLocation.text = "Latitude: " + location.latitude + " , Longitude: " + location.longitude
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == locationPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(parent, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(parent, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }

    }

    }