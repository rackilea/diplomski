return request.bodyToMono(User.class)
            .flatMap(body -> userRepository.findById(body.getUsername())                              
                                           .filter(user -> user.isActive())
                                           .filter(user -> passwordEncoder.matches(body.getPassword(), user.getPassword()))
            )
            .flatMap(user -> ServerResponse.ok().syncBody(tokens.store(user)))
            .switchIfEmpty(ServerResponse.badRequest().build());