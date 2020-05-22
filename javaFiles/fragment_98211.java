@RequestMapping(value = "image/", method = RequestMethod.GET)
 public ResponseEntity<String>  getChequeImage(HttpSessionsession,@PathVariable("itemId") Integer itemId,
                                    HttpServletResponse response) {

    try{
        InputStream in =  new FileInputStream(new File("path_to_image.jpg"));

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        byte[] binaryData = IOUtils.toByteArray(in)
        byte[] encodeBase64 = Base64.encodeBase64(binaryData);
        String base64Encoded = new String(encodeBase64, "UTF-8");
        return new ResponseEntity<String>(base64Encoded , headers, HttpStatus.OK);
    }catch (IOException e){
        LOGGER.error(e);
        e.getMessage(), response);
        return null;
    }
}