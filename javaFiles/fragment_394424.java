class Person {
   private String lastName;
   private String firstName;
   public Person(String lastName, String firstName) {
      this.lastName = lastName;
      this.firstName = firstName;
   }
   @Override
   public String toString() {
      return "Person [lastName=" + lastName + ", firstName=" + firstName + "]";
   }


}