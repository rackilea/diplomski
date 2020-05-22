public Student(String name, String rollno, Date dob) {
        super();
        this.name = name;
        this.rollno = rollno;
        this.dob = new Date(dob.getTime());
    }