public static void main(String args[]) {
    String Str = "Welcome to the class";
    System.out.println("\nReturn value is:");
    String sub = Str.substring(2, 9);
    String wsRemoved = sub.replaceAll(" ", "");
    String wsBegginingRemoved = sub.replaceAll("^ *", "");
    String outputSub = Str.substring(2+(sub.length()-wsBegginingRemoved.length()), 9+(sub.length()-wsRemoved.length()+(sub.length() - wsBegginingRemoved.length())));
    System.out.println(outputSub);
}