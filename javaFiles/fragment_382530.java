import java.util.*;

public class SortExample {

  public static class Student {
    public String name;
    public String date;

    public Student(String name, String date) {
      this.name = name;
      this.date = date;
    }
  }

  public static class StudentComparator implements Comparator<Student> {
      @Override
      public int compare(Student s, Student t) {
         int f = s.name.compareTo(t.name);
         return (f != 0) ? f : s.date.compareTo(t.date);
      }
  }

  public static void main(String args[]) {
    ArrayList<Student> l = new ArrayList<Student>(Arrays.asList(
      new Student ("x","2010-10-5"),
      new Student ("z","2010-10-15"),
      new Student ("y","2010-10-05"),
      new Student ("x","2010-10-1")
    ));

    System.out.println("Unsorted");
    for(Student s : l) {
      System.out.println(s.name + " " + s.date);
    }

    Collections.sort(l, new StudentComparator());

    System.out.println("Sorted");
    for(Student s : l) {
      System.out.println(s.name + " " + s.date);
    }
  }
}