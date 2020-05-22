package com.stackoverflow.solutionmaker;

    import java.util.Calendar;
    import java.util.GregorianCalendar;
    import java.util.Scanner;

    public class StackOverflowSolutionsRunner {

        public static void main(String[] args) {

             Scanner inputReg = new Scanner(System.in);

              //initialization of attributes
              String IC = "";
              String name = "";
              String tel = "";

              int day = 0;
              int month = 0;
              int year = 0;
              //for date

              System.out.print("Enter IC number: ");
              IC = inputReg.nextLine();

              Calendar dob = new GregorianCalendar(year, month, day);

              System.out.print("Enter name: ");
              name = inputReg.nextLine();

              System.out.println("Enter Date of Birth (DD/MM/YYYY ): ");
              day = inputReg.nextInt();
              month = inputReg.nextInt();
              year = inputReg.nextInt();
              inputReg.nextLine(); // I added this line to fake an input

              System.out.print("Enter telephone number: ");
              tel = inputReg.nextLine();

              //Customer c = new Customer(IC, name, dob, tel);
              //customerList.add(c);

              //System.out.println("Customer " + c.getName() + " registered successfuly.");
              System.out.println(tel);      

} }