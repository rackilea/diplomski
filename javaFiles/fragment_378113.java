final String req = "{"
                 + "\"username\":\"ambre@domain.com\","
                 + "\"password\":\"test\","
                 + "\"scope\":\"" + settings.getScope() + "\","
                 + "\"connection\":\"Username-Password-Authentication\","
                 + "\"client_id\":\"" + settings.getClientId() + "\","
                 + "\"grant_type\":\"password\""
                 + "}";
         RestTemplate template = new RestTemplate();
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         HttpEntity<String> entity = new HttpEntity<>(req, headers);

         ResponseEntity<String> response = template.exchange("https://my-domain.auth0.com/oauth/ro", HttpMethod.POST, entity, String.class);