Observable<User> getUserResult = gitHubService.getUser("octocat").cache(1);

getUserResult.map(new Func1<User, Integer>() {
    @Override
    public Integer call(User user) {
        return user.id;
    }
}).subscribe(new Action1<Integer>() {
    @Override
    public void call(Integer id) {
        Log.d("Stream 1", "id = " + id);
    }
});

getUserResult.map(new Func1<User, String>() {
    @Override
    public String call(User user) {
       return user.login;
    }
}).subscribe(new Action1<String>() {
    @Override
    public void call(String login) {
        Log.d("Stream 2", "login = " + login);
    }
});