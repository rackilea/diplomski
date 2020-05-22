@RequestMapping(value = "/upload", method = RequestMethod.POST)
public @ResponseBody
ResponseEntity<byte[]> uploadImage(final FileUploadBean fileUploadBean) throws Exception {
  File file = null;
  try {
    final MultiValueMap<String, Object> requestParts = new LinkedMultiValueMap<>();

    final String tmpImageFileName = IMAGE_TMP_DIR + fileUploadBean.getFile().getOriginalFilename();
    file = new File(tmpImageFileName);
    fileUploadBean.getFile().transferTo(file);
    requestParts.add("file", new FileSystemResource(tmpImageFileName));

    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "multipart/form-data"); // Sending it like the client-form sends it

    ResponseEntity<byte[]> response = restTemplate.exchange(ImageUrlUtils.getUploadUrl(), HttpMethod.POST, new HttpEntity<>(requestParts, headers),
      byte[].class);

    return new ResponseEntity<>(response.getBody(), response.getStatusCode());
  } catch (Exception ex) {
    return new ResponseEntity<>((ex.getMessage).getBytes("UTF-8"),
      HttpStatus.INTERNAL_SERVER_ERROR);
  } finally {
    if (file != null && file.exists()) {
      file.delete();
    }
  }
}