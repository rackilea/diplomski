public static void main(String[] arg) {
  String encodedString = "Special¢Home!¬";
  String originalString = "Special[Home]^";
  Map<String, Charset> availableCharsets = Charset.availableCharsets();
  Set<String> keySet = availableCharsets.keySet();
  for (String key : keySet) {
    for (String key2 : keySet) {
      Charset charset = availableCharsets.get(key);
      Charset charset2 = availableCharsets.get(key2);
      try {
        String decodedString = new String(charset.encode(encodedString).array(), charset2);
        if (originalString.equals(decodedString)) {
          System.out.println(originalString + ":  " + charset + " -> " + charset2);
        }
      } catch (UnsupportedOperationException e) {
        /*  e.printStackTrace(); */
      }
    }
  }
}