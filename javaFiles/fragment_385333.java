public String decryptAsBase64(String clearData) {
  if(clearData.length() < 1) return "";
  byte[] encryptedData = clearData.getBytes();        
  byte[] decryptedData = decryptAsBase64(encryptedData);
  String str = Base64.encodeBytes(decryptedData);
  str = str.replace("+", "%2B");
  return str;
}