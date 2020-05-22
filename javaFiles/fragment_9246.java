public class Group {
    String title;
    @JsonSerialize(converter = ListUserConverter.class)
    List<User> members;
    String createdBy;
}