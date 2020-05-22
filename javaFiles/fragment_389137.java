@RequestMapping(value = "/upload/avatar/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> uploadAvatar(@PathVariable("userId") Long userId, MultipartHttpServletRequest request) throws IOException {
    String fileName = request.getFileNames().next();
    userService.addAvatar(userId, fileName, request.getFile(fileName));
    return new ResponseEntity<>(HttpStatus.OK);
}