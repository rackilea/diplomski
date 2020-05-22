WebClient
    .builder()
    .filter((request, next) -> {
            // you can mutate the request before sending it
            ClientRequest newRequest = ClientRequest.from(request)
                    .header("Something", "value").build();
            return next.exchange(newRequest);
})