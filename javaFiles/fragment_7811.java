@PostMapping(AdminToolConstants.MAPPING_CHECK_USER)
    public ResponseEntity checkUser(HttpServletResponse response, @RequestBody UserDto userDto) throws IOException{
        if (userService.checkUser(userDto)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
     }