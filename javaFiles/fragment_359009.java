override fun onMapSharedElements(names: MutableList<String>?,
                                 sharedElements: MutableMap<String, View>?) {
    // `reenterBundle` is the `Bundle` you have saved in step 3
    if (null != reenterBundle
            && reenterBundle!!.containsKey("KEY_FROM_ACTIVITY_2")
            && null != view) {
        val key = reenterBundle!!.getInt("KEY_FROM_ACTIVITY_2");
        val newSharedElement = ... // find corresponding view with the `key`
        val newTransitionName = ... // transition name of the view

        // clear previous mapping and add new one
        names?.clear()
        names?.add(newTransitionName)
        sharedElements?.clear()
        sharedElements?.put(newTransitionName, newSharedElement)
        reenterBundle = null
    } else {
        // The activity is exiting
    }                            
}