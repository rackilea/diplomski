package de.scrum_master.app;

public class Intake {
  public MyModel receiveJson(String... arguments) {
    return jacksonMagic(arguments, MyModel.class);
  }

  public MyModel jacksonMagic(String[] arguments, Class<?> clazz) {
    MyModel myModel = new MyModel();
    myModel.setMyField(arguments[0]);
    return myModel;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++)
      System.out.println(new Intake().receiveJson("foo"));
  }
}