@PutMapping(path = "/action", produces = "application/json; charset=UTF-8")
public ResponseEntity<Object> updateAction(@RequestBody Map payload) {
    if(payload.containsKey("")) {
        //Something
    }
}