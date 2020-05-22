@Entity
@Table(uniqueConstraints = 
    @UniqueConstraint(columnNames = {"idUser", "fld_firstName", "lastName"}))
class User {   
    @Id
    String idUser;

    @Column(name="fld_firstname")
    String firstName;       
    String lastName;       
    Integer age; 
}