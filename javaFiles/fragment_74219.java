@RequestMapping(...)
public ResponseEntity<?> getOne(...) {
    Something something = repository.findOne(...);
    if (something == null)
        return ResponseEntity.notFound().build();

    return ResponseEntity.ok(something);
}