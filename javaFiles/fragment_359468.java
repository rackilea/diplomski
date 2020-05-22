private static final int s_eof = -1;
private static final int s_byteBuffer = 10240;

private static void checkAndUpdateFile(File src, File dest) throws IOException {
  FileInputStream in = new FileInputStream(src);
  FileChannel srcChannel = in.getChannel();
  FileChannel destChannel = null;
  FileLock destLock = null;

  try {
    if (!dest.exists()) {
      final RandomAccessFile destFile = new RandomAccessFile(dest, "rw");
      destChannel = destFile.getChannel();
      destLock = destChannel.lock();
      copyFileChannels(srcChannel, destChannel);
      dest.setLastModified(src.lastModified());
    } else {
      final RandomAccessFile destFile = new RandomAccessFile(dest, "rw");
      destChannel = destFile.getChannel();
      destLock = destChannel.lock();
      if (!compareFileChannels(srcChannel, destChannel)) {
        copyFileChannels(srcChannel, destChannel);
        dest.setLastModified(src.lastModified());
      }
    }
  } finally {
    if (destLock != null) {
      destLock.release();
    }
    if (destChannel != null) {
      destChannel.close();
    }
    srcChannel.close();
    in.close();
  }
}

protected static void copyFileChannels(FileChannel src, 
                                       FileChannel dest) throws IOException {
  final long size = src.size();
  for (long pos = 0; pos < size; ) {
    long count = 
      ((size - pos) > s_byteBuffer) ? s_byteBuffer : (size - pos);
    pos += dest.transferFrom(src, pos, count);
  }
}

protected static boolean compareFileChannels(FileChannel a, 
                                             FileChannel b) throws IOException {
  if (a.size() != b.size()) {
    return false;
  } else {
    final ByteBuffer aBuffer = ByteBuffer.allocate(s_byteBuffer);
    final ByteBuffer bBuffer = ByteBuffer.allocate(s_byteBuffer);
    for (int aCh = a.read(aBuffer); s_eof != aCh; ) {
      int bCh = b.read(bBuffer);
      if (aCh != bCh || aBuffer.compareTo(bBuffer) != 0) {
        return false;
      }
      aBuffer.clear();
      aCh = a.read(aBuffer);
      bBuffer.clear();
    }
    return s_eof == b.read(bBuffer);
  }
}