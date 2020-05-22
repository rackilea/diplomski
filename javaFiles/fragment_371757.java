@RequestMapping(value="/upload", method = RequestMethod.POST, consumes="application/json")
  public ResponseEntity<String> upload(@RequestBody DataObject uploadedData)
    throws NoSuchAlgorithmException, InvalidKeyException, IOException {
    if(uploadedData == null) {
      log.info("Uploaded data was null.");
      return new ResponseEntity<String>("Data was null after upload.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    String receivedData = uploadedData.getData();
    log.info("" + receivedData);