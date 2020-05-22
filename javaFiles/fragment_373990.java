package yourjavapackage;

import yourscalapakcage.YourScalaClass;

public class YourJavaClass {

  public void do() {
    YourScalaClass ysc = new YourScalaClass("lol");

    String str = ysc.doSomethingAndReturnString();

    System.out.println(str);
  }
}