public class Response {

    private String name;
    @XmlElementWrapper(name="row") // Add this line here
    private List<Address> addressList;
}