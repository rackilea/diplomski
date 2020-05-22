@GetMapping(value = "/image")
public @ResponseBody byte[] getImage() throws IOException {
    InputStream in = getClass()
      .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
    return IOUtils.toByteArray(in);
}