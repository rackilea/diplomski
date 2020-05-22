override fun onBackPressed() {
        val fm = supportFragmentManager
        if (fm.backStackEntryCount > 0) { //if backstack contain any fragment than pop it
            fm.popBackStack()
        } else {                          // call super function normally 
            super.onBackPressed()
        }
    }