@Entity
   class Employee {

      @OneToOne(cascade=CascadeType.ALL)
      private Address address;

  }