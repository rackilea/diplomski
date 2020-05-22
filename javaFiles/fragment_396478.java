@Entity
@Table(name = "SupplierPurchases ")
@DiscriminatorValue("S")
public class SupplierPurchases extends Contractor {

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private Set<Payment> payments;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private Set<Orders> orders;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SupplierPurchases", 
        joinColumns = @JoinColumn(name = "Supplier_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "Purchase_id", referencedColumnName = "id"))
    private Set<Purchase> purchases;
}