public class Order {

    public Order(){
        super();
    }
    public Order(Long prodId, BigDecimal price) {
        this();
        this.prodId = prodId;
        this.price = price;
    }

    @XmlAttribute
    public Long orderId;

    public Long prodId;
    public BigDecimal price;

}