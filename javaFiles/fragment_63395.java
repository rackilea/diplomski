WebClient.create().get()
    .uri(builder -> builder.scheme("http")
                    .host("example.org").path("save")
                    .queryParam("name", "spring-framework")
                    .build())
    .retrieve()
    .bodyToMono(String.class);