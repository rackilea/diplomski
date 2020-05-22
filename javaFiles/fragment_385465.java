@Entity
public class Order {

    @JsonView(View.Default.class)
    private String id;

    @JsonView(View.Default.class)
    private String name;

    @JsonView(View.Default.class)
    private String address;

    @JsonView(View.Detailed.class)
    private List<Items> items;

    // Getters and setters
}