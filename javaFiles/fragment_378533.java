package com.stackovflow.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Grades {

        public static void main(String[] args){
            ArrayList<Student> list = new ArrayList<>();
            String fileName = "students.txt";
            try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
                while(input.ready()){
                    String line = input.readLine().trim();
                    String name = line.substring(0,line.lastIndexOf(' '));
                    int grade = Integer.parseInt(line.substring(line.lastIndexOf(' ')+1));
                    list.add(new Student(name, grade));
                }
                input.close();
                selectionSort(list);
                System.out.println(list);
            } catch (IOException e){
                    System.out.println(e.getMessage());
            }
        }

        private static void selectionSort(ArrayList<Student> list) {
            int pFill;
            int pTest;
            int pSmallest;
            Student temp;
            for (pFill = 0; pFill < list.size(); pFill++) {
                pSmallest = pFill;
                for (pTest = pFill + 1; pTest < list.size(); pTest++) {
                    Student pTestStudent = list.get(pTest);
                    Student pSmallestStudent = list.get(pSmallest);
                    if (pTestStudent.getGrade() < pSmallestStudent.getGrade()) {
                        pSmallest = pTest;
                    }
                }
                if(pSmallest!=pFill) {
                    temp = list.get(pSmallest); 
                    list.set(pSmallest, list.get(pFill));
                    list.set(pFill, temp);
                }
            }

        }
    }

//This class is to hold line data in your students.txt file
class Student{
    private String name;
    private int grade;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public Student(String name, int grade) {
        super();
        this.name = name;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", grade=" + grade + "]";
    }

}