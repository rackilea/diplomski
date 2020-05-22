@Entity
@Table(name = "ST_PRODUCT")
public class Product {
// OTHER columns
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ST_PRODUCT_SUBSIDIARY", joinColumns = { 
        @JoinColumn(
        name = "PRODUCT_ID", 
        nullable = false, 
        updatable =          false) }, 
    inverseJoinColumns = { @JoinColumn(name = "PARTNER_SUBSIDIARY_ID", 
                nullable = false, updatable = false) })

public List<ProductSubsidiary> getProductSubsidiaries() {
    return productSubsidiaries;
}
//Other columns
}