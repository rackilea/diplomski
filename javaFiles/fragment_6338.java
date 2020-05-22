// This is the class declaration, where the "implements" clause goes
public class Student implements Comparable<Student> {
     ...
     // This is the constructor, which can take whatever parameters you want
     public Student(String firstName, String lastName, float gpa) {
         ...
     }

     // This is the implementation of a method declared by the Comparable<Student> interface
     @Override
     public int compareTo(Student other) {
          ... 
     }
}