@GetMapping("/{id}")
    Optional<User> findById(@PathVariable("id") String id){
       ...
    }

    @GetMapping("/")
    List<User> findUsers(@RequestParam("username") String username){
       // if username is not empty, filter users
       // we could also filter with other user properties according to specs
       ...
    }