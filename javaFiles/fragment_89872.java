@Inject
@Named("user")
private Deserialiser<User> deserialiserImp;

public void test(String userString) {
    User user = deserialiserImp.get(UserString);
}