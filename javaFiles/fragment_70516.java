public void setAge(int age){
 if(age < 0){
  throw new IllegalArgumentException("Invalid age : " + age);
  //or if you don't want to throw an exception you can handle it otherways too
 }
}