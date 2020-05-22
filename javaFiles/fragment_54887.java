@Service 
public class IPAddressBasedAuthenticationProvider implements AuthenticationProvider {


     @Autowired
     private HttpServletRequest request;

     @Override
     public Authentication authenticate(Authentication authentication) throws AuthenticationException {

         String ipAddress = request.getRemoteAddr();
         // Check against your array.
         //return created authentication object (if user provided valid credentials)
    }
}