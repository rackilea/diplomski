public class Employee extends Person {

    double daySallary;
    double extraSum;

    Employee(String name, int age, boolean isMan, double daySallary) {
        super(name, age, isMan);
        this.daySallary = daySallary;
    }

    double calculateOvertime(double hours) {
        if (this.age < 18)
            extraSum = 0;
        else
            extraSum = (this.daySallary / 8) * hours * 1.5;
        return extraSum;
    }

    @Override
    public void showInfo() {
        System.out.println("Име: " + super.name + " | " + "години: " + super.age + " | " + "мъж ли е: " + " | "
                + super.isMan + " | " + "Допълнителна сума от оставане след работно време: " + this.extraSum);
    }
}