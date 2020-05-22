package com.rr87;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class YourSessionListener implements HttpSessionListener {
  @Override
  public void sessionDestroyed(HttpSessionEvent event) {
    // Implement logic to save last visited page to database...
  } 
  .
  .
  .
}