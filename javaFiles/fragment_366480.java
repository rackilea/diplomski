public void insert(String filename, long offset, byte[] content) {
  RandomAccessFile r = new RandomAccessFile(new File(filename), "rw");
  RandomAccessFile rtemp = new RandomAccessFile(new File(filename + "~"), "rw");
  long fileSize = r.length();
  FileChannel sourceChannel = r.getChannel();
  FileChannel targetChannel = rtemp.getChannel();
  sourceChannel.transferTo(offset, (fileSize - offset), targetChannel);
  sourceChannel.truncate(offset);
  r.seek(offset);
  r.write(content);
  long newOffset = r.getFilePointer();
  targetChannel.position(0L);
  sourceChannel.transferFrom(targetChannel, newOffset, (fileSize - offset));
  sourceChannel.close();
  targetChannel.close();
}