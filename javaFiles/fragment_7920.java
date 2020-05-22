package com;

import java.util.Scanner;

public class FFLAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the number of students");
        int numofstu = input.nextInt();
        double totalchange = 0;
        Student[] students = new Student[numofstu];
        for (int count = 0; count<numofstu;count++) {
            //Put data into A CLASS
            System.out.println("--------------------------------");
            Student student = new Student();
            System.out.print("Enter student name[ "+(count+1) + "]: ");
            student.setName(input.next());
            System.out.print("Input start weight[ "+(count+1) + "]: ");
            student.setStart(input.nextDouble());
            System.out.print("Enter end weight[ "+(count+1)+ "]: ");
            student.setEnd(input.nextDouble());
            totalchange += student.getChange();
            // PUT THE OBJECT IN ARRAY
            students[count] = student;
            System.out.println("--------------------------------");
        }

        System.out
                .println("Last Name\t\tStartWeight\t\tEnd Weight\t\tWeight Change");
        // PARSE THE ARRAY
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getName() + "\t\t"
                    + students[i].getStart() + "\t\t\t" + students[i].getEnd()
                    + "\t\t\t" + students[i].getChange());
        }

        double avg = totalchange / numofstu;
        System.out.println("Average weight change: " + avg);
    }

    static class Student {
        private String name;
        private double start;
        private double end;
        private double change;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getStart() {
            return start;
        }

        public void setStart(double start) {
            this.start = start;
        }

        public double getEnd() {
            return end;
        }

        public void setEnd(double end) {
            this.end = end;
        }

        public double getChange() {
            return start - end;
        }

    }
}