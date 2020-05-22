public Student(String sid, String name,  boolean isMale){       
  this.sid = sid;
  this.name = name;
  this.isMale = isMale;
  this.gender = (isMale) ? "Male" : "Female";
  courses = "30202";  // default is empty
}