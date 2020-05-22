public class test {
    public static void main(String [] args) {
        Student s = new Student();
        s.setGPA(3.5); //set Gpa
        System.out.println(s.getGPA());
    }

}
    class Student {
        private double GPA;
        private String name;


        public void setGPA(double GPA) {
            this.GPA = GPA;
        }


        public double getGPA() {
            return GPA;

    }

}