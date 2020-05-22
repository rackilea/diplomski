@PostMapping
    public ResponseEntity<?> createParameter(@RequestBody @Valid ParameterDTO parameterData) {
        int id = parameterService.saveParameter(parameterData);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }