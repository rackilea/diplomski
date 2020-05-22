public static void insert(RandomAccessFile raf, int dataToInsert)
                      throws IOException {

    // First remember insertion position:
    long insPos = raf.getFilePointer();

    // Next copy all data from this pos. For easier, go downward:
    raf.seek(raf.length() - 4);

    for (long pos = raf.getFilePointer(); pos >= insPos; pos -= 4) {
        // readInt() and writeInt() implicitly moves the file pointer
        raf.writeInt(raf.readInt());
        raf.seek(pos - 4);
    }

    // Copy done, insert new value:
    raf.seek(insPos);
    raf.writeInt(dataToInsert);
}