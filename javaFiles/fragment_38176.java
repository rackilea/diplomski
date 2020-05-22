User one = new User();
one.setName("Salem")
one.setLastName("Saberhagen");
one.setAddress("Somewhere");
one.setAge(1000);

User two = one.clone();
two.setAddress("Mars");
two.setAge(2000);

reflectionEquals(one, two); // -> False
reflectionEquals(one, two, "address", "age"); // -> True