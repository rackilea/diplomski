package com.stackoverflow.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMaxAmountOfThreads {
  public static void main(String[] args) {
    ExecutorService serivce = Executors.newFixedThreadPool(Integer.MAX_VALUE);
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      serivce.submit(new Runnable() {
        public void run() {
          try {
            Thread.sleep(Integer.MAX_VALUE);
          } catch (InterruptedException e) {
          }
        }
      });
      System.out.println(i);
    }
  }
}