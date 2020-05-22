public class Item {

    @JsonView(Views.Public.class)
    public int id;

    @JsonView(Views.Public.class)
    public int drawnum;

    @JsonView(Views.Internal.class)
    public String address;
}