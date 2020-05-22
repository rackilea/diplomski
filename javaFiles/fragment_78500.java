package de.scrum_master.app;

public class Reader extends Thread {
  private MyStructure myStructure;

  public Reader(MyStructure myStructure) {
    this.myStructure = myStructure;
  }

  @Override
  public void run() {
    myStructure.read(0);
  }
}