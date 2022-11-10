package com.refathasan.bhu_bd.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pdfview.PDFView
import com.refathasan.bhu_bd.R


class PrimaryFromFillUpFragment : Fragment() {
    lateinit var pdfViewer:PDFView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_primary_from_fillup,container,false)
        //return inflater.inflate(R.layout.fragment_primary_from_fillup, container, false)
        pdfViewer = view.findViewById(R.id.PrimaryFromFillUpPDF)
        pdfViewer.fromAsset("mathematics.pdf")
       // pdfViewer.getPageCount()
        pdfViewer.show()
        return view
    }
}