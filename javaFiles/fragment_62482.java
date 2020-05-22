public static void listStudents(){
        **Student s = new Student();**
        System.out.println("******LIST OF STUDENTS******");
        for(int y = 0; y < s.getNumStudents();y++){
            System.out.println(s.getList());
        }

}