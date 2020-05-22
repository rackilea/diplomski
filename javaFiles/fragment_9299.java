@PostMapping("/items")
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        Item savedItem = businessService.addAnItem(item);
        HttpHeaders httpHeaders = new HttpHeaders();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();

        UriComponents uriComponents =
                uriComponentsBuilder.path("/item/").buildAndExpand("/item/");
        httpHeaders.setLocation(uriComponents.toUri());
        return new ResponseEntity<>(savedItem, httpHeaders, HttpStatus.CREATED);
    }