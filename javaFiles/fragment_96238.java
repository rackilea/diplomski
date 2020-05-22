@PostMapping("/signin")
public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest,
                                          HttpServletResponse response) {

    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsernameOrEmail(),
                    loginRequest.getPassword()
            )
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = tokenProvider.generateToken(authentication);

    // set headers here
    response.addHeader("accessToken", jwt);      
    response.addHeader("tokenType", "Bearer");

    JwtAuthenticationResponse response = new JwtAuthenticationResponse();
    response.setUserId(/*userId here*/);
    response.setEmail(/*email here*/);

    return ResponseEntity.ok(response);
}