public class Student {

    String name;
    int score;

    public Student (String sname, int sscore) {
        name = sname;
        score = sscore;

    }
    public void greeting() {
        System.out.println("My name is: " + this.name + " " +"My score is:" + this.score);
    }
}