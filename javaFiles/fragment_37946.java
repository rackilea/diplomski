@Entity
Person {
   @Id
   Long id;
   ...
   @OneToOne
   @JoinColumn(name = "customer_fk")   
   Customer customer;
   //NO other customer_fk mapping!!!
}


@Entity
Customer {
  @Id
  Long id; 
}