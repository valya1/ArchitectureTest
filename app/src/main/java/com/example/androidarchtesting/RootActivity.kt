package com.example.androidarchtesting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class RootActivity : AppCompatActivity() {

    private val tabController: TabController by lazy {
        TabController(
            listOf(R.navigation.multimedia_graph, R.navigation.science_graph),
            supportFragmentManager,
            ::onReturnToTab
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.tab_science -> tabController.switchToTab(R.navigation.science_graph)
                R.id.tab_multimedia -> tabController.switchToTab(R.navigation.multimedia_graph)
            }
            true
        }

        intent?.let(tabController::handleDeeplink)

        bottomNavigationView.selectedItemId = R.id.tab_multimedia
    }

    private fun onReturnToTab(graph: Int) {
        bottomNavigationView.setOnNavigationItemSelectedListener(null)
        bottomNavigationView.selectedItemId = graph
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.tab_science -> tabController.switchToTab(R.navigation.science_graph)
                R.id.tab_multimedia -> tabController.switchToTab(R.navigation.multimedia_graph)
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}