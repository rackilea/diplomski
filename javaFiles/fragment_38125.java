@XmlRootElement(name="repositories")
@XmlAccessorType(XmlAccessType.FIELD)
public class Repositories {

@XmlElement
private List<Sets> set;

//getter and setter

}

@XmlAccessorType(XmlAccessType.FIELD)
public class Sets {

private Long id;
private String name;
private String spec;

//getter and setter

}