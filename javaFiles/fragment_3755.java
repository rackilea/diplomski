public class Items implements Serializable {

    private static final long serialVersionUID = -2428562977284114465L;

    @Id
    @Column(name="id")
    private int id;

    public String itemName;

    public String unitofPrice;

    public Float minimumPrice;

    public Float maximumPrice;