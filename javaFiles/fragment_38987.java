@PostMapping(value = "/process", consumes = APPLICATION_JSON_VALUE)
public ResponseEntity<String> process(@RequestBody Map data, HttpServletRequest request) throws IOException {
    if (data.containsKey("operatorName") && null == data.get("operatorName"))
        return ResponseEntity.badRequest().body("operatorName can not be null");
    //valid process
    return ResponseEntity.ok("success");
}