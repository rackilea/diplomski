package javaDay3;

import java.util.Scanner;

public class StudentGradeApp2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StudentGrade studgrad[] = new StudentGrade[10];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < studgrad.length; i++) {

            StudentGrade sg = new StudentGrade();

            System.out.print("Enter Math Grade = ");
            sg.mathgrade = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter English Grade = ");
            sg.enggrade = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Science Grade = ");
            sg.scigrade = Double.parseDouble(scanner.nextLine());

            studgrad[i] = sg;
        }

        for (StudentGrade info : studgrad)
            info.printInfo();
        scanner.close();
    }
}