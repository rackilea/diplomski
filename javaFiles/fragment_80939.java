public interface Category {
    String getName();
    Category getParent();
    List<Category> getSiblings();
    List<Category> getChildren();
    List<Category> getDescendants();
    void addChild(Category category);
    void addChildren(List<Category> categories);
}