public class Class {
  private final static int MAX_COUNT_OF_STUDENTS = 50;

  private int numberOfStudents;  
  private int numberOfBooks;

  public void setNumberOfStudents(int newCount) {
    numberOfStudents = newCount;
  }

  public boolean isFull() {
    return ( numberOfStudents <= MAX_COUNT_OF_STUDENTS );
  }
  ...