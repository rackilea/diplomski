filePipe = new File(tempDirectory, namedPipe.getName() + ".pipe");
    try {
        int pipeSize = 4096;
        randomAccessFile = new RandomAccessFile(filePipe, "rw");
        fileChannel = randomAccessFile.getChannel();
        mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, pipeSize);
        mappedByteBuffer.load();
    } catch (Exception e) {
    ...