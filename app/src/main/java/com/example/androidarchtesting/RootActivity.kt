package com.example.androidarchtesting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.multimedia.MultimediaFragment1
import kotlinx.android.synthetic.main.activity_main.*

class RootActivity : AppCompatActivity() {

    private val navController by lazy { hostFragment.findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        configureStartGraphAndGetId()
        bottomNavigationView.selectedItemId = R.id.tab_science
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.tab_multimedia -> navController.navigate(
                    NavGraphDirections.actionGlobalMultimediaGraph(MultimediaFragment1.Args("test", 1))
                )
//                R.id.tab_science -> navController.navigate(R.id.science_graph)
            }
            true
        }
    }

    private fun configureStartGraphAndGetId() {
        val navInflater = navController.navInflater
        val graph = navInflater.inflate(R.navigation.nav_graph)
        graph.startDestination = R.id.science_graph
        navController.graph = graph
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}