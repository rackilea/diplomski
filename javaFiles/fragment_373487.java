public Student addStudent(String first, String last, String home, String school){
        if( studentcount < 5 ){
            studentcount++;
            s5 = s4; s4 = s3; s3 = s2; s2 = s1;
            return s1 = new Student(first,last,home,school);
        }    
        System.out.println("No more students allowed in the class");
        return null;
    }