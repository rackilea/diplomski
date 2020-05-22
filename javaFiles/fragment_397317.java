class Main {
  public static void main(String[] args) {
    String matchingRegex = "((\\.+)(?=.*@)|(\\+.*(?=@)))";
    System.out.println("joe.bloggs+123@gmail.com".replaceAll(matchingRegex, ""));
    System.out.println("joebloggs+123@gmail.com".replaceAll(matchingRegex, ""));
    System.out.println("joe.bloggs@gmail.com".replaceAll(matchingRegex, ""));
    System.out.println("joe.bloggs.123@gmail.com".replaceAll(matchingRegex, ""));
    System.out.println("joe.bloggs.123+456@gmail.com".replaceAll(matchingRegex, ""));
    System.out.println("joebloggs@gmail.com".replaceAll(matchingRegex, ""));
    System.out.println("joe.bloggs.123+456.789@gmail.com".replaceAll(matchingRegex, ""));
  }
}