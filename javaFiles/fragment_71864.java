@RestController
@RequestMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class TestResource {

@PreAuthorize("hasAuthority('ROLE_USER')")
@RequestMapping(value = "somePath", produces = MediaType.APPLICATION_JSON_VALUE)
public Object apiEndpoint() {return null;}

}