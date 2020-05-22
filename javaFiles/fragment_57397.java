@Entity
@Table(name = "A_B_C")
public class name = "A_B_C" {

     @ManyToOne(cascade=CascadeType.ALL)
     @JoinColumn(name = "FK_B", nullable = false)
     private B b;

     @ManyToOne(cascade=CascadeType.ALL)
     @JoinColumn(name = "FK_C", nullable = false)
     private C c;

     //Getters, Setters, other attributes etc.
}