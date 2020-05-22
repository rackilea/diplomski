@GetMapping(value = "/get-file/{filename}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public byte[] getFile(@PathVariable String filename) throws IOException {
    File file = new File(
        "../../../../../BackEnd/target/POS-1.0.0/WEB-INF/classes/uploads/" + filename);
    InputStream inputStream = new FileInputStream(file);
    return IOUtils.toByteArray(inputStream);
  }