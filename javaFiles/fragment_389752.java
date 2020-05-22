User user; 

public Single<User> login(String username, String password) {
    return userRepository
               .login(username, password)
               .map((User u) -> {
                   user = u;
                   return u;
               });
}