package de.scrum_master.app;

public class Application {
  public static void main(String[] args) {
    Application application = new Application();
    application.doSomething();
    application.doSomethingElse();
  }

  @SecuredAPI
  public void doSomething() {
    System.out.println("Doing something before setting query");
    setQuery("my first query");
    System.out.println("Doing something after setting query");
  }

  public void doSomethingElse() {
    System.out.println("Doing something else before setting query");
    setQuery("my second query");
    System.out.println("Doing something else after setting query");
  }

  public void setQuery(String query) {
    System.out.println("Setting query to: " + query);
  }
}