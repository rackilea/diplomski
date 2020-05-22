@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
class Response {
    @XmlElement(required = false)
    private User user;
    @XmlElement(required = false)
    private Client client;
}

class User {
}

class Client {
}