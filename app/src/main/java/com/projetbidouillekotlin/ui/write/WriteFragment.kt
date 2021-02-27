package com.projetbidouillekotlin.ui.write

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import com.projetbidouillekotlin.R

class WriteFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_write, container, false)
        val editText: EditText = root.findViewById(R.id.editText)
        val button: Button = root.findViewById(R.id.button)
        val closeKeyboardBtn: Button = root.findViewById(R.id.closeKeyboardBtn)
        button.setOnClickListener {
            if (context != null) {
                val prefs: SharedPreferences = requireContext().getSharedPreferences("PBK", MODE_PRIVATE)
                prefs.edit().putString("text", editText.text.toString()).apply()
            }
            Toast.makeText(context, "Text Saved", LENGTH_LONG).show()
            editText.setText("")
        }
        closeKeyboardBtn.setOnClickListener { hideKeyboard() }
        return root
    }

    private fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}