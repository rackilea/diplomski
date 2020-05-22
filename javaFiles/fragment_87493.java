private <T extends SharingManager> void registerUsersInManager(Class<T> type, List<User> usersToRegister){
    final Constructor<T> constructor = type.getConstructor(User.class);
       for(User u: usersToRegister){
        registry.put(u, constructor.newInstance(u));
    }
}