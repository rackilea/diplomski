package de.scrum_master.app;

import org.springframework.web.bind.annotation.RequestMapping;

public abstract class PutController {
  @RequestMapping("/{id}")
  public void update(String id) {}
}