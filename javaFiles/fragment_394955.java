private fun removeItem(position: Int) {
    if(position < 0 || position >= records.size)
        return

    records.removeAt(position)
    notifyItemRemoved(position)
    notifyItemRangeChanged(position, records.size)
}