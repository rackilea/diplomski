Customer[] filtered = Stream.of(kunderne).filter(Customer::isGlad).map(
            cust -> new Customer(cust.name, cust.points, cust.glad)).toArray(
                  Customer[]::new);

      for (Customer c : filtered) {
         System.out.println(c.name + " " + c.points + " " + c.glad);
      }