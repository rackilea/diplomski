public class Student {
    private Integer age;
    private String name;
    private Integer id;

    @XmlTransient
    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @XmlTrasient
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

@XmlAttribute
public void setId(Integer id) {
    this.id = id;
    }

    public Integer getId() {
        return id;
    }
}