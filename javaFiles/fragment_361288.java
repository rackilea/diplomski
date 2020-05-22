@RequestMapping(value = "createPdf", method = RequestMethod.GET, produces = "application/pdf")
public ResponseEntity<byte[]> createPdf(HttpServletResponse response) {

    response.setContentType("application/pdf");

    byte[] contents = // populate pdf data

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    headers.set("Content-Disposition", "inline");

    return new ResponseEntity<>(contents, headers, HttpStatus.OK);        
}