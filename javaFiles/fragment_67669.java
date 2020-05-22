@XmlRootElement
public class MyBean {
    private String id;
    private String name;

    public MyBean() {
        super();
    }

    // Getters/Setters
}


String json = "...";
MyBean bean = new ObjectMapper().readValue(json, MyBean.class);