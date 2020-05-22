@RestController
public class MainLoginController {

  @RequestMapping("/manuallogin")
  ResponseEntity<Object> interceptLoginRequest ( ){
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    DefaultSavedRequest springSecuritySavedRequest = (DefaultSavedRequest) requestAttributes.getRequest()
                                                                                            .getSession()
                                                                                            .getAttribute( "SPRING_SECURITY_SAVED_REQUEST" );
    queryString = springSecuritySavedRequest.getQueryString();
    request.getSession().setAttribute( "queryString", queryString );

    return ResponseEntity.status( HttpStatus.FOUND )
                         .location( URI.create( dinosaurServer.getLoginUrl() ) )
                         .build();
  }

  @RequestMapping("/handshakeWithDinosaur")
  public ResponseEntity<Object> handshakeWithDinosaur ( String dinosaursToken ) {


    Authentication authentication = this.authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            dino.getUser(), dino.getPass()
        )
    );
    SecurityContext sc = SecurityContextHolder.getContext();
    sc.setAuthentication( authentication );
    request.getSession().setAttribute( SPRING_SECURITY_CONTEXT_KEY, sc );


    String queryString = String.valueOf( request.getSession().getAttribute( "queryString" ) );

    return ResponseEntity.status( HttpStatus.FOUND )
                         .location( URI.create( String.format( "%s?%s",SPRING_AUTH_ENDPOINT, queryString ) ) )
                         .build();
  }