public void setAge(int age) throws Exception {
  if (age <= 3) {
    throw new Exception("Age must be more than 3");
  }
  this.age = age;
}