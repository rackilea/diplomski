@Override
    public AccessTokenResponse login(KeycloakUser user) throws NotAuthorizedException {
        try {
            String uri = keycloakUrl + "/realms/" + keycloakRealm + 
                    "/protocol/openid-connect/token";
            String data = "grant_type=password&username="+
                    user.getUsername()+"&password="+user.getPassword()+"&client_id="+
                    keycloakClientId;

            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/x-www-form-urlencoded");

            HttpEntity<String> entity = new HttpEntity<String>(data, headers);
            ResponseEntity<AccessTokenResponse> response = restTemplate.exchange(uri, 
                    HttpMethod.POST, entity, AccessTokenResponse.class);            

            if (response.getStatusCode().value() != HttpStatus.SC_OK) {
                log.error("Unauthorised access to protected resource", response.getStatusCode().value());
                throw new NotAuthorizedException("Unauthorised access to protected resource");
            }
            return response.getBody();
        } catch (Exception ex) {
            log.error("Unauthorised access to protected resource", ex);
            throw new NotAuthorizedException("Unauthorised access to protected resource");
        } 
    }