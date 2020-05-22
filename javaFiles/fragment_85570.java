@RequestMapping(value = "/url", method = POST)
public ResponseEntity postYourObject(@RequestBody YourObject object) {
    if (true) {
        return new ResponseEntity<>("Something happened", HttpStatus.BAD_REQUEST);
    }
}