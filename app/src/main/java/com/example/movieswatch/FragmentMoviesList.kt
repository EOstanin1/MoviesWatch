package com.example.movieswatch

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class FragmentMoviesList: Fragment() {

    private var fragmentMoviesListClickListener : FragmentMoviesListClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Log.d("Test", "View is created")
        view?.findViewById<ConstraintLayout>(R.id.constraint_layout_movies_list)?.apply {
            setOnClickListener{
                fragmentMoviesListClickListener?.onMoviesListClickListener()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentMoviesListClickListener) {
            fragmentMoviesListClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentMoviesListClickListener = null
    }

    interface FragmentMoviesListClickListener {
        fun onMoviesListClickListener()
    }
}