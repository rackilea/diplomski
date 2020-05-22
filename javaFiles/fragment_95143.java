class StudentComparator implements Comparator<Student> {

        public int compare(Student stud1, Student stud2){

            int stu1ID = stud1.getId();       
            int stu2ID = stud2.getId();

           return stud1ID-stu2ID;
        }

    }