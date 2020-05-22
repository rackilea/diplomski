@JsonFilter("myBeanFilter")
public class MyBean implements Serializable {
    private String fName;
    private lName;
    private address;
    private Date currentTime;

    // Constructors, Getters/Setters
}

final MyBean bean = new MyBean();
final ObjectMapper mapper = new ObjectMapper();
final FilterProvider filters = new SimpleFilterProvider().addFilter("myBeanFilter",
    SimpleBeanPropertyFilter.filterOutAllExcept("currentTime"));
final String json = mapper.filteredWriter(filters).writeValueAsString(value);