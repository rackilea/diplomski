@Entity
@DiscriminatorValue("C")
public class CustomerOperations extends Contractor {

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Payment> payments;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Orders> orders;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CustomerSales", 
       joinColumns = @JoinColumn(name = "Customer_id", referencedColumnName = "id"), 
       inverseJoinColumns = @JoinColumn(name = "Sale_id", referencedColumnName = "id"))
    private Set<Sale> sales;
}