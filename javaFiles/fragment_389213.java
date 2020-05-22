@RequestMapping(path = "/search/test/{string1}", produces = APPLICATION_JSON_UTF8_VALUE)
@ResponseBody
public SearchResult search( @PathVariable String string1, @RequestParam Optional<String> string2) {
    if (!string2.isPresent()) {
        return service.getLastQueries(string1, string2);
    }
}