ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(myString.getBytes(StandardCharsets.UTF_8));
    ServletInputStream servletInputStream=new ServletInputStream(){
        public int read() throws IOException {
          return byteArrayInputStream.read();
        }
      }