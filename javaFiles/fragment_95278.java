public Mono<ServerResponse> handleLogin(ServerRequest request) {

    return request.bodyToMono(User.class)
                  .flatMap(body -> userRepository.findById(body.getUsername())
                  .filter(user -> passwordEncoder.matches(body.getPassword(), user.getPassword()))
                  .flatMap(user -> ServerResponse.ok().body(Mono.just(tokens.store(user)), String.class))
                  .switchIfEmpty(ServerResponse.badRequest().build());
}