@Entity
@Table(name="categories")
public class Category implements Serializable {
    ...
    @Id private BigInteger idCategory;
    @Basic private String description;
    ...
}

@Entity
@Table(name="employees")
public class Employee implements Serializable {
    ...
    @ManyToOne
    @JoinColumn(name="idcategory", referencedColumnName="idcategory")
    private Category category;
    ...
}