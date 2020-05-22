FileInputStream fileIn = new FileInputStream("Peeps.fhm");
  ObjectInputStream in = new ObjectInputStream(fileIn);
  Person[] peeps = in.readObject();
  System.out.println("Deserialized Data:");
  for (Person person : peeps) { 
      System.out.printf("First Name: %s MI: %s Last Name: %s%n", 
          person.getFname(), person.getMI(), person.getLname()); 
  }