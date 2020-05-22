WebTarget endpoint = client.target(url);
    Invocation.Builder builder = endpoint.
            request(MediaType.APPLICATION_JSON)
            .accept(MediaType.TEXT_PLAIN)
            .accept(MediaType.WILDCARD)
            .accept(MediaType.APPLICATION_JSON)
            .header("Authorization", token.getToken());