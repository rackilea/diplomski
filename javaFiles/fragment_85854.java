@SuppressWarnings("serial")
@Entity
@IdClass(ProductId.class)
@Table(name = "Product", catalog = "orangeDB")
public class Product implements java.io.Serializable {    
    private Integer prodId;
    private Category category;
    private char prefix = 'P';
    private String product;
    private int quantity;
    private double price;
    private int discount;

    @Id
    @Column(name = "prodId", nullable = false)
    public Integer getProdId() {
        return this.prodId;
    }

    public void setProdIt(Integer prodId) {
        this.prodId = prodId;
    }


    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catId", referencedColumnName = "catId", nullable = false, insertable = false, updatable = false)
    public Category getCategory() {
        return this.category;
    }

    public setProductId(ProductId productId){
        this.prodId = productId.getProdId();
        this.category = productId.getCategory();
    }

    //getter&setters
}