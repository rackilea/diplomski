public class Course{
  private String course = "CS101";
}


public class FinishedCourse extends Course{

  public void displayCourse(){

    System.out.println(super.course); //compilation error. 
    //You cannot access private variables even if it is in direct parent class
  }
}