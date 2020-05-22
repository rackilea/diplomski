public class ListUserConverter extends StdConverter<List<User>, List<String>> {
    @Override
    public List<String> convert(List<User> users) {
        return users.stream().map(User::getTitle).collect(Collectors.toList());
    }
}