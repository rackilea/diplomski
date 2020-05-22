List<Student> studentList = getStudentList();

 Object [][] objArray = new Object[studentList.size][];

 for(int i=0;i< studentList.size();i++){
    objArray[i] = new Object[1];
    objArray[i][0] = studentList.get(i);
 } 

 return objArray