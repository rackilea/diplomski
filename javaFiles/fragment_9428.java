public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    //custom authentication service
    private AuthLogic userDetailsImpl;

    public JwtAuthenticationProvider(AuthLogic userDetailsImpl) {
        this.userDetailsImpl = userDetailsImpl;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        //JWTUser is a custom class that extends the UserDetails class from spring
        JwtUser user = (JwtUser) userDetails;

        //call the custom auth service to check if the user exists in the database
        userDetailsImpl.loadUserByUsername(user.getUserID(), user.getUsername());
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        //get the token from a external authentication API
        String token = retrieveAccountData(new LoginWrapper(username, authentication.getCredentials().toString()));

        Claims claims = Jwts.parser()
                .setSigningKey(JWTKEY)
                .parseClaimsJws(token)
                .getBody();

        List<String> scopes = (List<String>) claims.get("scopes");
        int UserId = (int) claims.get("userID");
        List<GrantedAuthority> authorities = scopes.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());

        //return the User
        return new JwtUser(UserId, username, authentication.getCredentials().toString(), authorities);
    }

    private String retrieveAccountData(LoginWrapper loginWrapper){
        URI uri = UriComponentsBuilder.fromUriString(BANK_LOGIN).build().toUri();
        Gson gson = new GsonBuilder().create();

        RequestEntity<String> request = RequestEntity
                .post(uri)
                .accept(MediaType.APPLICATION_JSON)
                .body(gson.toJson(loginWrapper));

        //post call
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);

        //check if status code is correct
        if(response.getStatusCode() != HttpStatus.OK) {
            throw new UsernameNotFoundException(loginWrapper.getUsername());
        }

        //convert to LoginWrapper
        return gson.fromJson(response.getBody(), TokenWrapper.class).getToken();
    }
}