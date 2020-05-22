public class OBOTokenGranter extends AbstractTokenGranter {

    ...

    private UserDetailsService uds;

    public OBOTokenGranter(UserDetailsService uds, AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService,
        OAuth2RequestFactory requestFactory) {
       super(tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);

       this.uds = uds;
   }

   ...
 }