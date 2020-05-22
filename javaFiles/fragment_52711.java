import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    private static ArrayList<Student> array = new ArrayList<Student>();

    public static void main(String[] args) {
        array.add(new Student("John", "password1"));
        array.add(new Student("Jane", "password2"));
        array.add(new Student("Jack", "password3"));

        Student aStudent = new Student("Jack", "password3");
        boolean found = false;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).compareTo(aStudent) == 0) {
                System.out.println(aStudent.equals(array.get(i)));
                found = true;
                break;
            }
        }
        System.out.println(found);
    }

    public static class Student implements Comparable<Student> {

        private String name;
        private String password;

        public Student(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public int compareTo(Student object) {
            int result = 1;
            if ((this.getName().compareToIgnoreCase(object.getName()) < 0) || (this.getPassword().compareTo(object.getPassword()) < 0)) {
                result = -1;
            } else if ((this.getName().compareToIgnoreCase(object.getName()) == 0) && (this.getPassword().compareTo(object.getPassword()) == 0)) {
                result = 0;
            }

            return result;

        }
    }

}