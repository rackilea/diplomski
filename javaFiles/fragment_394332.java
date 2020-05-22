public class Person implements Serializable {
    private static final long serialVersionUID = 38L;

    private String firstname;
    private String lastname;
    private String address;
    private Foo[] images;
}

public class Foo{
    private Image image;
}
public class Image implements Serializable {
    private static final long serialVersionUID = 39L;

    private String url;
    private String id;
}