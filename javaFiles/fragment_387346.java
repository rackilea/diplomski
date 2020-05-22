import java.util.*;
import java.io.*;

  public class MyClass {

  private ArrayList<String> MyArray = new ArrayList<String>();
  private Scanner scan;

  public MyClass(){

    try {
      scan = new Scanner(new File("MyFile.csv"));
    } catch (IOException ioex) {
      System.out.println("File Not Found");
    }

  }

  public ArrayList<String> getArray() {

    while (scan.hasNext()) {
      Scanner line = new Scanner(scan.nextLine());
      MyArray.add(line.next());

    }
    return MyArray;
  }

  }