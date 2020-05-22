writerLock.lock();
try {
    readerLock.lock();
    try {
        readerCount++;
    } finally {
        readerLock.unlock();
    }
} finally {
    writerLock.unlock();
}
System.out.println("Reader "+id+" reading ("+readerCount+" readers)");