private void layoutItems(int width) {
    int numItems = getChildCount();
    if (numItems == 0) {
        mLayoutNumRows = 0;
        return;
    }

    // Start with the least possible number of rows
    int curNumRows =
            Math.min((int) Math.ceil(numItems / (float) mMaxItemsPerRow), mMaxRows);

    /*
     * Increase the number of rows until we find a configuration that fits
     * all of the items' titles. Worst case, we use mMaxRows.
     */
    for (; curNumRows <= mMaxRows; curNumRows++) {
        layoutItemsUsingGravity(curNumRows, numItems);

        if (curNumRows >= numItems) {
            // Can't have more rows than items
            break;
        }

        if (doItemsFit()) {
            // All the items fit, so this is a good configuration
            break;
        }
    }
}