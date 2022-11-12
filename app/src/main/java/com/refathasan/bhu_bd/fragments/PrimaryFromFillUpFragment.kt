package com.refathasan.bhu_bd.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.PDFView.Configurator
import com.github.barteksc.pdfviewer.listener.OnRenderListener
import com.refathasan.bhu_bd.R


class PrimaryFromFillUpFragment : Fragment() {
    lateinit var pdfView: PDFView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_primary_from_fillup, container, false)
        //return inflater.inflate(R.layout.fragment_primary_from_fillup, container, false)
        pdfView = view.findViewById(R.id.pdfView)
        pdfView.fromAsset("mathematics.pdf")
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .defaultPage(0)

            .load()

        return view
    }

}