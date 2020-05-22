package de.scrum_master.app;

import java.util.function.Supplier;

public class A {
  public Object foo(Supplier<?> msg) {
    return msg.get();
  }
}