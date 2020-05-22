@RequestMapping(...)
public ResponseEntity<?> yourMethod(...) {
    // business-logic
    if (some condition) {
        return new ResponseEntity<String>(address, HttpStatus.OK);
    } else if (...) {
        return new ResponseEntity<Long>(walletId, HttpStatus.OK);
    }
}