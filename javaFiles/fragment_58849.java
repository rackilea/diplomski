Flux.just(userId1, userId2, userId3)
    .map(repo::findById)
    .concatMap(user-> {
        if(!isValid(user)){
            return Flux.error(new InvalidUserException());
        }
        return Mono.just(user);
    })