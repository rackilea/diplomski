public class SomeView {
    private UserLister userLister;

    public void render() {
        List<User> users = userLister.getUsers();
        view.render(users);
    }
}