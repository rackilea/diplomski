@RepositoryRestController
@RequestMapping("/users") // or 'user'? - check this...
public class UserController {

    @Autoware 
    private UserRepo userRepo;

    @Transactional 
    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable("id") String id) { // or Long id?..

        // custom logic

        return ResponseEntity.noContent().build();
    }
}