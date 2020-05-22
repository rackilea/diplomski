Person johnWayne = Person.builder()
  .firstName("John")
  .lastName("Wayne")
  .dob("05-26-1907")
  .build();

Person johnWayneClone = johnWayne.copy() // returns a builder!
  .dob("06-25-2014")
  .build();