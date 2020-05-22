public class Foo
{
  @JsonSetter("teams")
  public void asdf(List<Team> teams)
  {
    System.out.println("hurray!");
  }

  public List<Team> getTeams()
  {
    // generate unmodifiable list, to fail if change attempted
    return Arrays.asList(new Team());
  }

  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    String fooJson = mapper.writeValueAsString(new Foo());
    System.out.println(fooJson);
    // output: {"teams":[{"name":"A"}]}

    // throws exception, without @JsonSetter("teams") annotation
    Foo fooCopy = mapper.readValue(fooJson, Foo.class);
    // output: hurray!
  }
}

class Team
{
  public String name = "A";
}