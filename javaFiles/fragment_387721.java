File dir = Environment.getExternalStorageDirectory();
        File yourFile = new File(dir, "path/to/the/file/inside/the/sdcard.ext");
        String encodeFileToBase64Binary = encodeFileToBase64Binary(yourFile);

        private static String encodeFileToBase64Binary(File fileName) throws IOException {
              byte[] bytes = loadFile(fileName);
              byte[] encoded = Base64.encodeBase64(bytes);
              String encodedString = new String(encoded);
              return encodedString;
         }