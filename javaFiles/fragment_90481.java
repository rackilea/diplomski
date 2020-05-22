class Student extends ResponseDTO{
   publci String name = "John"
}
...
@ResponseBody ResponseDTO  getStudentInfo(){
  return new Student();
}