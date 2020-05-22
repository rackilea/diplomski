package de.scrum_master.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
  public static void main(String[] args) {
    MyStructure structureA = new MyStructure("One");
    MyStructure structureB = new MyStructure("Two");
    List<Thread> threads = Arrays.asList(
      new Writer(structureA), new Writer(structureB), new Writer(structureA), new Writer(structureB),
      new Reader(structureA), new Reader(structureB), new Reader(structureA), new Reader(structureB),
      new Reader(structureA), new Reader(structureB), new Reader(structureA), new Reader(structureB)
    );
    Collections.shuffle(threads);
    for (Thread thread : threads)
      thread.start();
  }
}