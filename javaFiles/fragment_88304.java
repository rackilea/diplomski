public ResponseEntity<Property> updateProperty(@RequestBody PropertyWrapper property,
                                               @PathVariable String id) {   
  final ResponseEntity<Property> response = 
          new ResponseEntity<Property>(property.getProperty(), HttpStatus.OK);
  return response;
}