@Override
    public String user(String authToken) throws NotAuthorizedException {

        if (! authToken.toUpperCase().startsWith(BEARER)) {
            throw new NotAuthorizedException("Invalid OAuth Header. Missing Bearer prefix");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<AccessToken> response = restTemplate.exchange(
                keycloakUrl + "/realms/" + keycloakRealm + "/protocol/openid-connect/userinfo", 
                HttpMethod.POST, 
                entity, 
                AccessToken.class);

        if (response.getStatusCode().value() != HttpStatus.SC_OK) {
            log.error("OAuth2 Authentication failure. "
                    + "Invalid OAuth Token supplied in Authorization Header on Request. Code {}", response.getStatusCode().value());
            throw new NotAuthorizedException("OAuth2 Authentication failure. "
                    + "Invalid OAuth Token supplied in Authorization Header on Request.");
        }

        log.debug("User info: {}", response.getBody().getPreferredUsername());
        return response.getBody().getPreferredUsername();
    }