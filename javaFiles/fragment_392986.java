@RequestMapping(value = "/kml")
public ResponseEntity<byte[]> kml(HttpServletRequest request) throws IOException
{   //get your input stream here 
    InputStream is = request.getServletContext().getResourceAsStream("/WEB-INF/1.0_week_age.kml");
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    return new ResponseEntity<byte[]>(IOUtils.toByteArray(is), headers, HttpStatus.CREATED);
}