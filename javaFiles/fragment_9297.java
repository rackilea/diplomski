@PostMapping("/items")
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        Item savedItem = itemBusinessService.addAnItem(item);

        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }