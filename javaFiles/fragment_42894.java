public class Student implements Comparable{

    int index;
    private double grade;

    public Student(int i, double d) {
        grade = d;
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;

        if (s.getGrade() < grade){
            return -1;
        } else if (s.getGrade() == grade) {
            return 0;
        }
        return 1;
    }
}