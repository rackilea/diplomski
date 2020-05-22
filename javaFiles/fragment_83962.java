public class DbStudent {
    private String firstName;
    private String lastName;
    private Integer id;
    private String sub;
    private String percent;

public DbStudent(String firstName, String lastName, int id, String sub, String percent) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.sub = sub;
    this.percent = percent;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getFirstName() {
    return firstName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getLastName() {
    return lastName;
}

public void setId(Integer id) {
    this.id = id;
}

public Integer getId() {
    return id;
}

public void setSub(String sub) {
    this.sub = sub;
}

public String getSub() {
    return sub;
}

public void setPercent(String percent) {
    this.percent = percent;
}

public String getPercent() {
    return percent;
}