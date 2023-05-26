package com.example.movieswatch

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment() {

    private var fragmentMoviesDetailsClickListener : FragmentMoviesDetailsClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view?.findViewById<ImageView>(R.id.pathMovie)?.apply {
            setOnClickListener{
                fragmentMoviesDetailsClickListener?.onMoviesDetailsClickListener()
            }
        }
        view?.findViewById<TextView>(R.id.backMovie)?.apply {
            setOnClickListener{
                fragmentMoviesDetailsClickListener?.onMoviesDetailsClickListener()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentMoviesDetailsClickListener) {
            fragmentMoviesDetailsClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentMoviesDetailsClickListener = null
    }

    interface FragmentMoviesDetailsClickListener {
        fun onMoviesDetailsClickListener()
    }
}