@RequestMapping(value="getSVG")
public @ResponseBody ResponseEntity<String> getSVG(HttpServletRequest request, HttpServerletResponse response) {
    String SVG = // build the SVG XML as a string
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.valueOf("image/svg+xml"));
    ResponseEntity<String> svgEntity = new ResponseEntity<String>(svg, headers, HttpStatus.OK);
    return svgEntity;
}