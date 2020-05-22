@JacksonXmlRootElement(localName = "person") 
@JsonInclude(JsonInclude.Include.NON_EMPTY) 
public class Person implements Serializable {
    @JsonIgnore 
    private Long id;
    @JacksonXmlProperty(localName = "name") 
    private String name;
    @JacksonXmlProperty(localName = "email") 
    private String email;
    @JacksonXmlProperty(localName = "address") 
    private Address address;
    private String birthday;

   //getter and setter 
}