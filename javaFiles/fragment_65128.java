public ResponseEntity<User> getUser(@PathVariable("id") int id) {
    User User= this.userService.getUserById(id);
    ResponseEntity<User> responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
    if (Optional.ofNullable(user).isPresent()) {
        responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
    }

    return responseEntity;
}