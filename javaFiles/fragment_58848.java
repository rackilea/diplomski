Mono.just(userId)
    .map(repo::findById)
    .concatMap(user-> {
        if(!isValid(user)){
            return Mono.error(new InvalidUserException());
        }
        return Mono.just(user);
    })