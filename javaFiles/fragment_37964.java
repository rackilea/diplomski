@Override
public Mono<User> createUser(Mono<User> userMono) {
    return userMono.flatMap(user -> 
                            methodToCallGoogleApiAndSetValueToUser(user))
                   .subscribe(reactiveMongoOperations::save)
}