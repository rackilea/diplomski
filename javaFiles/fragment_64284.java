try {
    // Get a file channel for the file
    File file = new File("filename");
    FileChannel channel = new RandomAccessFile(file, "rw").getChannel();

    // Use the file channel to create a lock on the file.
    // This method blocks until it can retrieve the lock.
    FileLock lock = channel.lock();

    // ** Your logic here **
} finally {
    // Release and close 
    lock.release();
    channel.close();
}