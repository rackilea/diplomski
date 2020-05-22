public class Category {

  private List<Category> children = new ArrayList<Category>();
  private Category parent;
  private String name;

  // private constructor
  private Category(Category parent, String name) { 
    this.parent = parent; 
    this.name = name;
  }

  // adds a category to this category
  public Category addCategory(String name) { 
     Category child = new Category(this, name);
     children.add(child); 
     return child;
  }

  // creates and returns a new categories tree
  public static Category createCategories() {
     return new Category(null, "root");
  }
}