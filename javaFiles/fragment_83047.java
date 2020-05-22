@CrossOrigin(maxAge = 3600)
@PostMapping("auth")
@ResponseBody
public ResponseEntity<?> authenticate(@RequestBody Map<String, String> body) {
    // sending some response for the sake of testing
    body.put ("response","valid and successful");
    return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
}