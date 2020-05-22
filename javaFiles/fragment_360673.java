lazyUsers = new LazyUserDataModel() {
    @Override
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }
};