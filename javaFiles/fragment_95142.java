class StudentComparator implements Comparator<Student> {

    public int compare(Student stud1, Student stud2){

        int stu1ID = stud1.getId();       
        int stu2ID = stud2.getId();

        if(stu1ID > stu2ID)
            return 1;
        else if(stu1ID < st21ID )
            return -1;
        else
            return 0;    
    }

}