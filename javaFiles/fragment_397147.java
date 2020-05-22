Optional<Grocery> groceryOptional = groceryRepository.findById(id);
if(groceryOptional.isPresent()){
    return ResponseEntity.ok(groceryOptional.get());
}else {
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(MessageUtil.parse(MSG_404_GROCERY, id + ""));
}