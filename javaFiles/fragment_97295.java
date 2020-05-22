@RestController
 public class OBOTokenGenerator {

 ...

    @Autowired
    private UserDetailsService uds;

 ...
    @RequestMapping("/obo/{user}")
    public ResponseEntity<OAuth2AccessToken> getOBOToken(Principal principal, @PathVariable("user") String user) {

 ...

        OBOTokenGranter granter = new OBOTokenGranter(uds, tokenServices, clientDetailsService, requestFactory);

 ...
 }