public String pad(String fileName, int len) {
  if (fileName.length() >= len) {
    return fileName;
  }
  String padded = "0000000" + fileName;  // Change the number of zeros to your needs
  return  padded.substring(padded.length() - len); 
}