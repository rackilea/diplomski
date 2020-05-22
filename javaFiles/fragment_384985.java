// get the URIs from somewhere
Flux<URI> uris = //...

Flux<MyAnyEntity> entities = uris
                // map each URI to a HTTP client call and do nothing with the response
                .flatMap(uri -> webClient.get().uri(uri).exchange().then())
                // chain that call with a call on your repository
                .thenMany(repo.findAll());