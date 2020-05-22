RandomAccesFile raf = null;
try {
    raf = new RandomAccessFile(f);
    //do stuff
} finally {
   if (raf != null) {
      raf.close();
   }
}