@JsonPropertyOrder({
"accId",
"groupOf",
"isEnabled"
})
@JsonInclude(JsonInclude.Include.NON_NULL)

public class DynamicJsonHelper {

public String accId;
public String groupOf;
public List<Student> studentList;

@JsonProperty("accId")
public void setAccId(String accId) {
    this.accId = accId;
}

@JsonProperty("groupOf")
public void setGroupOf(String groupOf) {
    this.groupOf = groupOf;
}

@JsonProperty("isEnabled")
public boolean isEnabled() {
    return false;
}

@JsonProperty("studentList")
public void setStudentList(List<Student> list) {
    this.studentList = list;
}

}

class Student {
private String student;
private String type;
private String retro; 

public Student(String student, String type, String retro) {
    this.student = student;
    this.type = type;
    this.retro = retro;
}

public String getStudent() {
    return student;
}

public void setStudent(String student) {
    this.student = student;
}

public String getType() {
    return type;
}

public void setType(String type) {
    this.type = type;
}

public String getRetro() {
    return retro;
}

public void setRetro(String retro) {
    this.retro = retro;
}    
}

class HelperTest{

public static void main(String[] args) throws JsonProcessingException {
    DynamicJsonHelper dynamicJsonHelper = new DynamicJsonHelper();
    String jsonString;
    ObjectMapper mapper = new ObjectMapper();

    dynamicJsonHelper.setAccId("12345");

    List<Student> list = Arrays.asList(new Student("s1", "t1", "r1"), new Student("s2", "t2", "r2"));

    dynamicJsonHelper.setStudentList(list);
    jsonString = mapper.writeValueAsString(dynamicJsonHelper);
    System.out.println(jsonString);

}
}