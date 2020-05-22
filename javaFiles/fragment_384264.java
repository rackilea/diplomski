static void joinFiles(File[] files) throws Exception {
    int maxReadBufferSize = 8 * 1024;

    BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(INPUT_FILE + "_Splits\\fullJoin"
            + FILE_SUFFIX));

    RandomAccessFile raf = null;
    for (File file : files) {
        raf = new RandomAccessFile(file, "r");
        long numReads = raf.length() / maxReadBufferSize;
        long numRemainingRead = raf.length() % maxReadBufferSize;
        for (int i = 0; i < numReads; i++) {
            readWrite(raf, bw, maxReadBufferSize);
        }
        if (numRemainingRead > 0) {
            readWrite(raf, bw, numRemainingRead);
        }
        raf.close();

    }
    bw.close();
}

public static void joinFiles() throws Exception {

    File[] files = new File[NUMBER_OF_OUTPUT_FILES];
    for (int i = 1; i <= NUMBER_OF_OUTPUT_FILES; i++) {
        files[i - 1] = new File(INPUT_FILE + "_Splits\\split." + i + FILE_SUFFIX);
    }

    joinFiles(files);
}