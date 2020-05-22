package de.scrum_master.app;

import java.util.ArrayList;
import java.util.List;

public class MyStructure {
  private String name;
  private List<String> myList;

  public MyStructure(String name) {
    this.name = name;
    myList = new ArrayList<String>();
    myList.add("dummy element to permit reading");
  }

  public void insert(String value) {
    myList.add(value);
  }

  public void read(int pos) {
    myList.get(pos);
  }

  @Override
  public String toString() {
    return "MyStructure[" + name + "]";
  }
}