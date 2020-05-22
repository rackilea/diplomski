package com.testingarea;

class Kdc {

  public Kdc() {
    runKdc();
  }

  private void runKdc() {
    while(true) {
      System.out.println("Running kdc");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}

class RunKdc implements Runnable {

  @Override
  public void run() {
    Kdc k = new Kdc();      
  }

}

public class TestThread {

  public static void main(String[] args) {
    new Thread(new RunKdc()).start();
    System.out.println("Kdc thread started");
  } 


}