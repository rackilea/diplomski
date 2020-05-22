package myawesomeproject;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        try {
            loadStudent();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void loadStudent() throws FileNotFoundException {
        try (Scanner input = new Scanner(getClass().getResourceAsStream("studentData.txt"))) {
            while (input.hasNext()) {
                String info = input.nextLine();
                System.out.println(info);
                String elements[] = info.split(" , ");
                String fName = elements[0];
                String lName = elements[1];
                String phone = elements[2];
                String address = elements[3];
                double gpa = Double.parseDouble(elements[4]);
                String major = elements[5];

            }
        }
    }
}