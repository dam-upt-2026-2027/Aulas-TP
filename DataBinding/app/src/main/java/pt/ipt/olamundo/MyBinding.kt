package pt.ipt.olamundo

import android.view.View

data class MyBinding(var txtDizOla: String) {

    fun mostraBotao():Int {
        if (txtDizOla.length < 100)
            return View.VISIBLE
        else
            return View.INVISIBLE
    }
}
