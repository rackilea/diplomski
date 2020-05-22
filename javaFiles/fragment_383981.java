package org.acme.foo;

@XmlRootElement
class Person {
  private String name;

  public String getName() { return name; }
  public void setName(String) { this.name=name; }
}

@XmlRegistry
class ObjectFactory {
  Person createPerson() { ... }
}