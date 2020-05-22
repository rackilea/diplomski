if (n==1){
    System.out.println("Here is a list of the students:");

    //******I would like to move the printing here******
    List<Student> students = Menu.populate();
    for(Student student: students) {
        student.PrintInfo();
    }
} else if (n==2){
    System.out.println("Here is a list of the teachers:");
}