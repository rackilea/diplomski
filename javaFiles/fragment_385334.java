public String decryptAsBase64(String clearData) {
    if(clearData.length() < 1) return "";
    byte[] encryptedData = null;
    try {
        encryptedData = Base64.decode(clearData);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    byte[] decryptedData = decrypt(encryptedData);
    String str = null;
    try {
        str = new String(decryptedData, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return str;
 }