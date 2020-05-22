@RequestMapping(value = "/test", method = RequestMethod.GET)
public ResponseEntity<String> throwException(
    @RequestParam(value = "flag", defaultValue = "false") Boolean flag
) throws Exception {
    if (flag) {
        throw new Exception();
    } else {
        ResponseEntity response = ResponseEntity.ok().
            contentType(MediaType.APPLICATION_XML).
            body("<xml>hello</xml>");
        return response;
    }
}