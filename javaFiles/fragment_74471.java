protected String loadFromFile(String fileName) throws IllegalStateException {
       StringBuilder buffer = new StringBuilder(2048);
       try {
           InputStream is = getClass().getResourceAsStream(fileName);
           LineNumberReader reader = new LineNumberReader(new InputStreamReader(is));
           while (reader.ready()) {
               buffer.append(reader.readLine());
               buffer.append(' ');
           }
       } catch (Exception e) {
           throw new IllegalStateException("couldn't load file " + fileName, e);
       }
       return buffer.toString();
   }