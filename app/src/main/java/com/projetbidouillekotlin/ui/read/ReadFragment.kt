package com.projetbidouillekotlin.ui.read

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.projetbidouillekotlin.R

class ReadFragment : Fragment() {

    private lateinit var dashboardViewModel: ReadViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(ReadViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_read, container, false)
        val textView: TextView = root.findViewById(R.id.text_read)
        dashboardViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }
}