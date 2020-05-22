public void actionPerformed (ActionEvent event)
 {
       if(!firstSchoolOfJava.equals(idField.getText()))
       {
           // input should first be parsed to an int (id type is an int)
           int id = Integer.parseInt(idField.getText());
           Student s;
           for (int i = 0; i < firstChoolOfJava.getStudents().size(); i++){
               // check to see if the ids match. If they do, remove that student
               if ((firstChoolOfJava.getStudents().get(i).getID()) == id) {
                   s = firstChoolOfJava.getStudents().get(i);
                   firstSchoolOfJava.remove(s);  // you're removing this student
                   break;
               }                   
           }
       }
       System.out.println(firstSchoolOfJava.toString());
 }