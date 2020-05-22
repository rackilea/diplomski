import java.util.HashMap;
import java.util.HashSet;

public class Recipe {
  private String id;
  private HashMap<String, HashSet<String>> uses;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public HashMap<String, HashSet<String>> getUses() {
    return uses;
  }

  public void setUses(HashMap<String, HashSet<String>> uses) {
    this.uses = uses;
  }

  @Override
  public String toString() {
    return "Recipe{" + "id='" + id + '\'' + ", uses=" + uses + '}';
  }
}