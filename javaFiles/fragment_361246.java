package de.scrum_master.app;

public class Child implements Runnable {
  @Override
  public void run() {
    System.out.println(String.format("[%d] Running in the child thread", Thread.currentThread().getId()));
  }
}