public class myStudent {
    private Student student_obj = new Student();

    public void show_grades() {
       System.out.println(student_obj.studGrade);
       System.out.println(student_obj.studID);
    }

    public void change_grades(){
        student_obj.studGrade='V';
        student_obj.studID=10;
    }
}