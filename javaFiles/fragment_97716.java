class UserController {
    @GetMapping("/byId/{id}")
    Optional<User> findById(@PathVariable("id") String id){
       ...
    }

    @GetMapping("/byName/{username}")
    Optional<User> findByUsername(@PathVariable("username") String username){
       ...
    }
}