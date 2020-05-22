while (rs.next()){
 name = rs.getString("name");
 age = rs.getInt("age");
 address = rs.getString("address");
         System.out.println("Name is " + name +" age is " + age + " Address is " + address);
         rs.next();
 }