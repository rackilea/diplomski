val icons = ArrayList<Int>()
val arr = resources.obtainTypedArray(R.array.dashboard_item_menu_drawable)
(0 until arr.length()).forEach {
    // get resource id of each drawable
    val icon = arr.getResourceId(it, -1)
    icons.add(icon)
}