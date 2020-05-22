@JacksonXmlRootElement(localName = "open")
class OpenCredentials {

    @JacksonXmlProperty(localName = "creds")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Credentials[] credentials;

    //getters, setters, toString
}


class Credentials {

    @JacksonXmlProperty(isAttribute = true)
    private String priv;

    @JacksonXmlProperty(isAttribute = true)
    private String type;

    private String user;

    @JacksonXmlProperty(localName = "client_token")
    private String clientToken;

    @JacksonXmlProperty(localName = "client_secret")
    private String clientSecret;

    //getters, setters, toString
}