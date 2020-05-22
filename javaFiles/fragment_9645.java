@Data
public class Taco {

  @Size(min=1, message="You must choose at least 1 ingredient")
  private List<String> ingredients;

  public Taco() {
     ingredients = new ArrayList<>()
  }

}