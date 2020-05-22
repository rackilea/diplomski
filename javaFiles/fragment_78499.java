package de.scrum_master.app;

public class Writer extends Thread {
  private MyStructure myStructure;

  public Writer(MyStructure myStructure) {
    this.myStructure = myStructure;
  }

  @Override
  public void run() {
    myStructure.insert("example");
  }
}