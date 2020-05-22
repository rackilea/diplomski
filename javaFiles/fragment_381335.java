public PageRankSparse( String filename, boolean doIterate ) {
    int noOfDocs = readDocs( filename );
    NUMBER_OF_DOCS = noOfDocs;
    if (doIterate) {
        iterate( noOfDocs, 1000 );
    }
}