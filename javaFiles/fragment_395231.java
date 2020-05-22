public static String choices(String value1, String value2) {
    Scanner x = new Scanner(System.in);
    System.out.println("Type your choice and ENTER...");
    String input = x.nextLine();
    if (input.equals(value1)) {
        return value1;
    }
    else if (input.equals(value2)) {
        return value2;
    }
    // handling other user inputs
    else {
        return "nothing";
    }
}

public static void main(String[] args) {
    // usage of method. Note that you could also refactor with varargs, as in: 
    // String... values in method signature.
    // This way you could iterate over values and check an arbitrary number of values, 
    // instead of only 2.
    System.out.println(choices("foo", "bar"));
}