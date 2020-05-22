Customer c1 = new Customer();
c1.additionalData = new LinkedHashMap<> ();
c1.additionalData.put ("transactions", 14);
Customer c2 = new Customer();
c2.additionalData = new LinkedHashMap<> ();
c2.additionalData.put ("transactions", 7);
Customer c3 = new Customer();
c3.additionalData = new LinkedHashMap<> ();
List<Customer> customers = Arrays.asList (c1,c2,c3);
int sum = customers.stream()
                   .map(c->(Integer)c.additionalData.get("transactions"))
                   .filter(Objects::nonNull)
                   .mapToInt (Integer::intValue)
                   .sum();
System.out.println ("sum is " + sum);