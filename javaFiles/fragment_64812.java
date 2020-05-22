public class Views {
    public static class Filtered {}
    public static class All extends Filtered {}
}

public class Student {
    private String name;

    @JsonProperty("class")
    private String clazz;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}

public class Score {
    @JsonView(Views.Filtered.class)
    private String subject;

    @JsonView(Views.Filtered.class)
    private String marks;

    @JsonView(Views.All.class)
    private Student student;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

public class JsonTest {
    public static void main(String[] args) throws JsonProcessingException {
        Student student = new Student();
        student.setName("x");
        student.setClazz("8");

        Score score = new Score();
        score.setSubject("math");
        score.setMarks("100");
        score.setStudent(student);

        ObjectMapper mapper = new ObjectMapper();

        //do not serialize student property
        System.out.println(mapper.writerWithView(Views.Filtered.class).writeValueAsString(score));

        //also serialize student property
        System.out.println(mapper.writeValueAsString(score));
    }
}