@RequestMapping(value = "/upload", method = RequestMethod.POST)
public ResponseEntity<?> uploadFile(@RequestParam("data") MultipartFile uploadfile) {
    logger.debug("Single file upload!");
    if (uploadfile != null && uploadfile.isEmpty()) {
        return new ResponseEntity("please select a file!", HttpStatus.OK);
    }
    return new ResponseEntity("Successfully uploaded - " + uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
}