public static void main(String[] args) {
  Console c = System.console();
  String username = c.readLine("Please enter your username: ");
  String password = c.readLine("Please enter your password: ");

  Guice.createInjector(new LoginModule(username, password));
}