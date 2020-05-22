navigation.setOnNavigationItemSelectedListener(this)

override fun onNavigationItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
        R.id.navigation_catalog -> {
            swapFragments(item.itemId, "Catalog")
            return true
        }
        R.id.navigation_shopping_cart -> {
            swapFragments(item.itemId, "ShoppingCart")
            return true
        }
        R.id.navigation_account -> {
            swapFragments(item.itemId, "Account")
            return true
        }
    }
    return false
}


private fun swapFragments(@IdRes actionId: Int, key: String) {
    if (supportFragmentManager.findFragmentByTag(key) == null) {
        savedFragmentState(actionId)
        createFragment(key, actionId)
    }
}

private fun savedFragmentState(actionId: Int) {
    val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_home)
    if (currentFragment != null) {
        savedStateSparseArray.put(currentSelectItemId,
                supportFragmentManager.saveFragmentInstanceState(currentFragment)
        )
    }
    currentSelectItemId = actionId
}

private fun createFragment(key: String, actionId: Int) {
    when (actionId) {
        R.id.navigation_catalog -> {
            val fragment = CatalogFragment.newInstance(key)
            fragment.setInitialSavedState(savedStateSparseArray[actionId])
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_home, fragment, key)
                    .commit()
        }
        R.id.navigation_shopping_cart -> {
            val fragment = ShoppingcartFragment.newInstance(key)
            fragment.setInitialSavedState(savedStateSparseArray[actionId])
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_home, fragment, key)
                    .commit()
        }
        R.id.navigation_account -> {
            val fragment = AccountFragment.newInstance(key)
            fragment.setInitialSavedState(savedStateSparseArray[actionId])
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_home, fragment, key)
                    .commit()
        }
    }

}