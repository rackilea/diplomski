public Student {
   String id; //or int, or char[8]
   String firstName, lastName;
   String address;
  //and so on

  //constructor - Given a line of input from the data file, create a Student object
  public Student(String line) {
     id = line.substring(0,8);
     //and so on

  }