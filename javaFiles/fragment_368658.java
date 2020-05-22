boolean isAllInvalid= true;
for(Student student : students){ 
 if(student.getID() != null && studend.getID() >=1 ){// this checks for a valid id 
  system.out.print(student+ " has a valid id");
  isAllInvalid =false; 
  break;//early exit no need to keep looping cuz we found at least one valid id ,if you to print all valid remove the break statement.
 } 
}
 if(isAllInvalid){
   throw new SomeException("All students are invalid") ;//choose ur suitable exception
 }