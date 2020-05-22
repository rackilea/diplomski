@RequestMapping(value="/book", produces=MediaType.APPLICATION_JSON)
public ResponseEntity<Map> bookInfo() {
    Map test = new HashMap();
    test.put("uno", "uno");
    return ResponseEntity.accepted().body(test);
}