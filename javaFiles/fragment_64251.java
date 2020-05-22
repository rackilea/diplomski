public class test {
    public static void main(String [] args) {
        Student s = new Student(5,"Khan");
        System.out.println("The given Gpa is " + s.getGPA() + " and name is " + s.getName());
        s.setGPA(3.5); //change Gpa
        System.out.println(s.getGPA()+ "The gpa has been changed");
    }

}
    class Student {
        private double GPA;
        private String name;
        public Student(double Gp,String Name) {
            this.GPA = Gp;
            this.name = Name;
        }

        public String getName() {
            return this.name;
        }

        public void setGPA(double GPA) {
            this.GPA = GPA;
        }


        public double getGPA() {
            return GPA;

    }

}