public boolean addStudentInLine(Integer id) { 

   for(Student stu : inClass) {

       if (stu.ID.equals(id)) {
           inClass.add(id);
           return true;
        }

     }  
    return false;
 }