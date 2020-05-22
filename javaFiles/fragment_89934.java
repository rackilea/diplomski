@RequestMapping(value = "/fileService/temp/{temporalLink}", method = RequestMethod.GET)
public ResponseEntity<byte[]> getFileByTemporalLink(@PathVariable @NotNull String temporalLink) {

    byte[] fileContent; // get the file content somehow
    String fileName; // and file name
    String mediaType; // and media type

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType(mediaType));
    headers.setContentDispositionFormData("attachment", fileName);
    return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
}