public class Student extends Person {

    double score;

    Student(String name, int age, boolean isMan, double score) {
        super(name, age, isMan);
        this.score = score;
    }

    @Override
    public void showInfo() {
        System.out.println("Име: " + super.name + " | " + "години: " + super.age + " | " + "мъж ли е: " + " | "
                + super.isMan + " | " + "Оценка: " + this.score);
    }

    // SETTERS and GETTERS
}