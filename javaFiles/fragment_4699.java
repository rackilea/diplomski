@Entity
  public class Thing {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     // Your Primary Key

     // Getters, setters, constructors, oh my!

     @PrePersist
     @PreUpdate
     public void prePersist() {
       // get JCache client instance
       // serialize object
       //store in cache
     }
}