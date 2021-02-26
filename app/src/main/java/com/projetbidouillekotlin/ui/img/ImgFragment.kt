package com.projetbidouillekotlin.ui.img

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.projetbidouillekotlin.R

class ImgFragment : Fragment() {

    private lateinit var homeViewModel: ImgViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(ImgViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_image, container, false)
        val textView: TextView = root.findViewById(R.id.text_image)
        homeViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }
}