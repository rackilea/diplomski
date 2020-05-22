@Table(name = "Items")
public class Item extends Model {
    @Column(name = "Name")
    public String name;

    @Column(name = "Category")
    public Category category;
}