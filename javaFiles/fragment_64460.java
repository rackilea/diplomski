@XmlRootElement(name = "category")
public class Category {

    String id;
    String name;
    List<Category> path;
    List<Category> subCategories;

    public String getId() {
        return id;
    }

    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getPath() {
        return path;
    }

    @XmlElementWrapper(name = "path")
    @XmlElement(name = "category", type = Category.class)
    public void setPath(List<Category> path) {
        this.path = path;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    @XmlElementWrapper(name = "subCategories")
    @XmlElement(name = "category", type = Category.class)
    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }
}