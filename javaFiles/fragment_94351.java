public class SerializableCookie implements Serializable {

    private String name;
    private String path;
    private String domain;
    // ...

    public SerializableCookie(Cookie cookie) {
        this.name = cookie.getName();
        this.path = cookie.getPath();
        this.domain = cookie.getDomain();
        // ...
    }

    public String getName() {
        return name;
    }

    // ...

}