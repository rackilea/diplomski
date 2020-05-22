@RestController
@RequestMapping("/test")
public class NamingController {

    @RequestMapping(value="/jsontopojo", method = RequestMethod.POST)
    public ResponseEntity<User> jsontopojo(@RequestBody User nam) {
        return new ResponseEntity<User>( nam, HttpStatus.OK);
    }

}