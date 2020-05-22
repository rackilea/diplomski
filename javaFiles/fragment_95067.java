if (o1.get(FeedConstants.PUBLICATION_YEAR) instanceof String) {
    if (o2.get(FeedConstants.PUBLICATION_YEAR) instanceof String) {
        // Perform the comparison here like you are
    } else {
        /*
         * This could also be 1, the key is to have it consistent
         * so the final sorted list clearly separates the FeedDocuments
         * with a String PUBLICATION_YEAR and those without one.
         */
        return -1;
    }
} else if (o2.get(FeedConstants.PUBLICATION_YEAR) instanceof String) {
    /*
     * In this case, o1 doesn't have a String PUBLICATION_YEAR and o2
     * does, so this needs to be the opposite of the return value
     * 6 lines up to be consistent.
     */
     return 1;
} else {
     /*
      * Consider all FeedDocuments without a String PUBLICATION_YEAR
      * to be equivalent, otherwise you could do some other comparison
      * on them here if you wanted.
      */
     return 0;
}