try(InputStream is = connection.getInputStream(); 
   ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

  int read = 0;
  byte[] buffer = new byte[4096];

  while((read = is.read(buffer)) > 0) {
    baos.write(buffer, 0, read);
  }

  return new String(baos.toByteArray(), StandardCharsets.UTF_8);
} catch (Exception ex){}