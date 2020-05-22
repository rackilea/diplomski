@Entity
@Table(name = "products")
public class Product { 

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "product_voucher",   // insert join table name here
        joinColumns = { @JoinColumn(name = "product_id") }, // insert product column name from join table here 
        inverseJoinColumns = { @JoinColumn(name = "voucher_id") } // // insert voucher column name from join table here
    )
    Set<Voucher> vouchers = new HashSet<>();

    // standard constructor/getters/setters
}


@Entity
@Table(name = "vouchers")
public class Voucher {    

    @ManyToMany(mappedBy = "vouchers")
    private Set<Product> products = new HashSet<>();

    // standard constructors/getters/setters   
}