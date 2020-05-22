@RestController
@RequestMapping(value="/store")
public class StoreRestController {

    @Autowired
    Store store;

    @RequestMapping(value="/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Store> getStore(HttpServletRequest request) {
        ResponseEntity<Store> response = new ResponseEntity<Store>(store, HttpStatus.OK);
        return response;
    }
}