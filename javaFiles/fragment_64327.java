@PostMapping("/create")
private ResponseEntity<String> createNewUser(@RequestBody UserCreateDTO newUser) {
    Status status = userService.createUser(newUser);
    return ResponseEntity.status(status.isSuccess() ?
            HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(status.getInfo());
}