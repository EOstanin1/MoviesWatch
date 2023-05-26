package com.example.movieswatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout

class MainActivity : AppCompatActivity(), FragmentMoviesList.FragmentMoviesListClickListener, FragmentMoviesDetails.FragmentMoviesDetailsClickListener {

    private val fragmentMoviesList = FragmentMoviesList()
    private val fragmentMoviesDetails = FragmentMoviesDetails()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*var fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()*/

        if (savedInstanceState == null) {
            /*fragmentTransaction.apply {
                add(R.id.fragment_container, fragmentMoviesList)
                commit()
            }*/
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragmentMoviesList, MOVIES_FRAGMENT_TAG)
                .commit()
        } else supportFragmentManager.findFragmentByTag(MOVIES_FRAGMENT_TAG) as? FragmentMoviesList
    }

    companion object {
        const val MOVIES_FRAGMENT_TAG = "moviesFragment"
        private const val TAG = "Test"
    }

    override fun onMoviesListClickListener() {
        //Log.d(TAG, "Is clicked")
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragmentMoviesDetails)
            .addToBackStack(null)
            .commit()
    }

    override fun onMoviesDetailsClickListener() {
        supportFragmentManager.popBackStack()
    }
}