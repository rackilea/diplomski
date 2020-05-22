File file = new File(filePath);
       FileInputStream fileInputStreamReader = new FileInputStream(file);
       StringBuilder sb = new StringBuilder();
       Base64.Encoder encoder = java.util.Base64.getEncoder();
       int bufferSize = 3 * 1024; //3 mb is the size of a chunk
       byte[] bytes = new byte[bufferSize]; 
       int readSize = 0;

       while ((readSize = fileInputStreamReader.read(bytes)) == bufferSize) {
            sb.append(encoder.encodeToString(bytes));
       }

       if (readSize > 0) {
            bytes = Arrays.copyOf(bytes, readSize);
            sb.append(encoder.encodeToString(bytes) );
       }

       String encodedBase64  = sb.toString();