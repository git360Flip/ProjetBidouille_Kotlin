package com.projetbidouillekotlin.ui.read

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.projetbidouillekotlin.R

class ReadFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_read, container, false)
        val textView: TextView = root.findViewById(R.id.textView)
        val prefs: SharedPreferences = requireContext().getSharedPreferences("PBK", MODE_PRIVATE)
        textView.text = prefs.getString("text", "No Text Saved")
        return root
    }
}