FileOutputStream fos = null;
try {
  fos = new FileOutputStream(destination);

  if(this.ftp.retrieveFile(source, fos)) {
    return true;
  } else {
    return false;
  }
} catch (IOException e) {
  return false;
} finally {
  if(fos != null)
    fos.close();
}