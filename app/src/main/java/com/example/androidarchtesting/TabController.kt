package com.example.androidarchtesting

import android.content.Intent
import android.util.SparseArray
import androidx.annotation.NavigationRes
import androidx.core.util.set
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment

class TabController(
    private val graphs: List<Int>,
    private val hostsCreator: (tab: Int) -> NavHostFragment,
    private val topFragmentManager: FragmentManager,
    private val onReturnToTab: (graphId: Int) -> Unit
) {

    private var currentBackstackCount = 0
    private val hostFragments = SparseArray<NavHostFragment>()

    fun switchToTab(@NavigationRes graphId: Int) {

        topFragmentManager.addOnBackStackChangedListener {
            val backStackCount = topFragmentManager.backStackEntryCount
            if (backStackCount < currentBackstackCount) {
                val visibleHost = topFragmentManager.findFragmentById(R.id.containerView) as? NavHostFragment
                    ?: return@addOnBackStackChangedListener
                onReturnToTab(visibleHost.navController.graph.id)
            }
            currentBackstackCount = backStackCount
        }

        topFragmentManager.commit {
            replace(R.id.containerView, getOrCreateNavProvider(graphId))
            addToBackStack(null)
        }
    }

    fun handleDeeplink(intent: Intent) {
        for (graph in graphs) {
            if (getOrCreateNavProvider(graph).navController.handleDeepLink(intent)) return
        }
    }

    private fun getOrCreateNavProvider(graphId: Int): NavHostFragment {
        return hostFragments.getOrPut(graphId, NavHostFragment::create)
    }

    private fun <T> SparseArray<T>.getOrPut(key: Int, provider: (Int) -> T): T {
        return get(key) ?: provider(key).also { this[key] = it }
    }
}
