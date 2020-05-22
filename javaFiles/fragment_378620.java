UriComponents components = UriComponentsBuilder.newInstance()
                            .scheme("https")
                            .host("1.1.1.1")
                            .path("/cgi-bin/login")
                            .queryParam("name", "test@email.com").build();
URI uri = components.toUri();
System.out.println(uri);