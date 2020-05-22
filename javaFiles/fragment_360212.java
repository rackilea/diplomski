// Set action to perform when any menu-item is selected.
    bottom_navigation.setOnNavigationItemSelectedListener { item ->
        item.isChecked = true
        selectFragment(item)
        false
    }
private fun selectFragment(item: MenuItem?) {
    item?.isChecked = true
    when (item?.itemId) {
        R.id.action_uploadFile -> {
         // here define fragment change
        }

    }
}