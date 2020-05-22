@Entity
@Indexed
public class Product {
    private long id;
    @Field
    private String title;
    @IndexedEmbedded
    private Category category;
}

@Entity
public class Category {
    @Field // Added this
    private long id;
    @Field
    private String name;
}