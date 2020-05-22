@RequestMapping(value="/sparql/query", method=RequestMethod.GET)
public ResponseEntity<String> queryViaGet(@RequestHeader(value="Accept") final List<MediaType> contentTypes)
{
    MediaType.sortBySpecificityAndQuality(contentTypes);

    // Do some stuff to select your content type and generate your response
    final String results = null;
    final MediaType desiredType = null;

    // Create your REST response
    final HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setContentType(desiredType);
    return new ResponseEntity<String>(results, responseHeaders, HttpStatus.OK);
}