@JsonRootName(value = "user")
public static class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

}

ObjectMapper om = new ObjectMapper();
om.configure(Feature.UNWRAP_ROOT_VALUE, true);
System.out.println(om.readValue("{  \"user\":    {      \"name\":\"Sam Smith\",      \"age\":1  }}", User.class));