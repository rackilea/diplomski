public Class Student {
    private int id;
    private String name;

    Student() {
    }

    Student(int i, String n) {
        this.id = i;
        this.name = n;
    }

    //Add here getters & setters
}

public Class ClassRoom {
    public static void main (String args[]) {
        Student student1 = new Student(1, "John");
        Student student2 = new Student(2, "Sarah");

        System.out.println(student1.getId()); //This should print 1
        System.out.println(student2.getId()); //This should print 2

        //You may achieve the same result as follows:
        Student student3 = new Student();
        student3.setId(3);
        student3.setName("George");

        System.out.println(student3.getId()); //This should print 3
    }
}