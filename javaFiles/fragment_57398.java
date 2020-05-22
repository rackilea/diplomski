@Entity
 @Table(name = "A")
 public class name = "A" {

          @OneToMany(cascade=CascadeType.ALL)
          @JoinColumn(name = "FK_A", nullable = false)
          private Set<A_B_C> abc;

          //Getters, Setters, other attributes etc.
 }