Customer[] filtered = Stream.of(kunderne).filter(Customer::isGlad).map(
            Customer::new).toArray(Customer[]::new);

      for (Customer c : filtered) {
         System.out.println(c.name + " " + c.points + " " + c.glad);
      }

     // modified customer class with additional constructor

    class Customer {
       public String  name;
       public int     points;
       public boolean glad;

       public Customer(String name, int points, boolean glad) {
          this.name = name;
          this.points = points;
          this.glad = glad;
       }

       public Customer(Customer cust) {
          this(cust.name, cust.points, cust.glad);
       }

       public boolean isGlad() {
          return this.glad;
       }
    }