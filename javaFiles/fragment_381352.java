BufferedInputStream bufIn = new BufferedInputStream(myInputStream);
bufIn.mark(contentLength);
ZipInputStream zipIn = new ZipInputStream(bufIn);
boolean foundSpecial = false;
while ((entry = zin.getNextEntry()) != null) {
  if("special.txt".equals(entry.getName())) {
    // do whatever you need with the special entry
    foundSpecial = true;
    break;
  }
}

if(foundSpecial) {
  // rewind
  bufIn.reset();
  zipIn = new ZipInputStream(bufIn);
  // ....
}