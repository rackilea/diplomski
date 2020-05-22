package de.scrum_master.app;

public class MyModel {
  private String myField;

  public void setMyField(String myField) {
    this.myField = Helper.doStuff(myField);
  }

  @Override
  public String toString() {
    return "MyModel(myField=" + myField + ")";
  }
}