public boolean addStudentInLine(Integer id) { 

   for(int i = 0; i<inClass.size(); i++) {

       if (inClass.get(i).ID.equals(id)) {
           inClass.add(id);
           return true;
        }

     }  
    return false;
 }