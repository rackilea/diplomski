@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleBean implements Serializable {
    private String name;
    private Integer pos;

    // constructors, getters, setters
}

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestBean implements Serializable {
    private List<SimpleBean> toAdd;
    private List<SimpleBean> toRemove;

    // constructors, getters, setters
}