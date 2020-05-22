@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = { "personNameHeader", "personAgeHeader" })
static class PersonDetailsCSVTemplate
{
    @JsonProperty("personNameHeader")
    private String name;

    @JsonProperty("personAgeHeader")
    private String age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "PersonDetailsCSVTemplate [name=" + name + ", age=" + age + "]";
    }
}