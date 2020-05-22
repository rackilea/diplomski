public class Sample {

    private String name;
    private String age;
    private String status;
    private String message;

    @JsonIgnore        // Added Annotation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore        // Added Annotation
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}