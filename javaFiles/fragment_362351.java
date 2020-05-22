Mono<User> userMono = request.bodyToMono(User.class);//Create a Mono<User>

userMono.map((user) -> { //In the map method, we access to the User object directly
  if(user != null && user.getId() != null){
    return userRepository.insert(user); // Insert User instead of Mono<User> in your repository
  }
  return null;
}) //This is still a Mono<User>
.map(insertedUser -> ServerResponse.ok(insertedUser)) //This is a Mono<ServerResponse>
.switchIfEmpty(ServerResponse.ok());