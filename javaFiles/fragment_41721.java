package by.dev.madhead.demo;

import static java.lang.System.out;

public class Employee {
    private String name;
    private String jobTitle;

    public void setName(String nameIn) {
        name = nameIn;
    }

    public String getName() {
        return name;
    }

    public void setJobTitle(String jobTitleIn) {
        jobTitle = jobTitleIn;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void cutCheck(double amountPaid) {
        out.printf("Pay to the order of %s ", name);
        out.printf("(%s)", jobTitle);
        out.printf(" ***$%,.2f\n", amountPaid);
    }

    public static void main(String args[]) {
        Employee e = new Employee();

        e.setName("Drake");
        e.setJobTitle("Programmer");

        e.cutCheck(57005.12);
    }
}