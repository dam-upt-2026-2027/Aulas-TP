package pt.ipt.fragmentoa

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var f1:MyFragment
    lateinit var f2:MyFragment
    lateinit var f3:MyFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        f1 = MyFragment.newInstance("ola","mundo")
        f2 = MyFragment.newInstance("OLA","mundo")
        f3 = MyFragment.newInstance("OLA","MUNDO")

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment1, f1)
        fragmentTransaction.add(R.id.fragment2, f2)
        fragmentTransaction.add(R.id.fragment3, f3)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()


    }
}