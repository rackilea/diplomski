/**
 * Load the data section of the file into the variables in memory. This may be expensive on memory, use with care on large datasets
 *
 * @throws SPSSFileException
 * @throws IOException
 */
public void loadData() throws IOException, SPSSFileException {
    if (dataStartPosition < 1) {
        // this has not been initialized, we don't actually know where the data starts
        throw new SPSSFileException("Error: data location pointer not initialized.");

    }
    SPSSDataRecord data = new SPSSDataRecord();

    SPSSDataRecord.clusterIndex = 8; //---This is the fix!!!
    seek(dataStartPosition);
    for (int i = 0; i < infoRecord.numberOfCases; i++) {
        // log("\nRECORD "+(i+1)+" offset "+this.getFilePointer());
        data.read(this);
    }
    isDataLoaded = true;
}