@Controller
public class SSOController {

    @Autowired
    private IdSClientConfigurationImpl config;

    @Autowired 
    private IdSClient client;

    @PostMapping("/login")
    public String login(@RequestParam(name="user", required=true) String user) {
        // redirect the user to the Cisco Contact Center Express Identity Service
        String redirectURI = config.getRedirectUri();
        String clientId = config.getClientId();

        URI uri = UriComponentsBuilder
                .fromUriString("https://contact-center-express:8553/ids/v1/oauth/authorize")
                .queryParam("redirect_uri", "{redirect_uri}")
                .queryParam("client_id", "{client_id}")
//              .queryParam("state", "{state}") // base64 encoded
                .queryParam("response_type", "code")
                .build(redirectURI, clientId);
        return "redirect:"+uri.toString();
    }

    @GetMapping("/idscallback")
    public String idscallback(
            @RequestParam(name="code", required=true) String code, 
            @RequestParam(name="state", required=false) String state,
            HttpSession session) throws IdSClientException {

        // Get Access Token for the received Authorization Code
        String redirectURI = config.getRedirectUri();
        AccessToken token = client.getAccessToken(code, redirectURI); // why do I need redirectURI when it's already redirected?
        String accessTokenString = token.getAccess_token();
        session.setAttribute("token", accessTokenString);
//      model.addAttribute("token", accessTokenString);     
        return "redirect:/";
    }