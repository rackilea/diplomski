package org.springsuppressor;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class MyHandler extends ConsoleHandler {

  public MyHandler() {
    super();
    setLevel(Level.WARNING);
  }
}