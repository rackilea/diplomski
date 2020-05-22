public static void main(String[] args) {
    String input1 = "Request ECUReset for [*11 01]";
    String output1 = input1.substring(input1.indexOf("[*")+"[*".length(), input1.indexOf("]", input1.indexOf("[*")));
    System.out.println(input1 + " --> " + output1);

    String input2 = "Request ECUReset for [*11]";
    String output2 = input2.substring(input2.indexOf("[*")+"[*".length(), input2.indexOf("]", input2.indexOf("[*")));
    System.out.println(input2 + " --> " + output2);

    String input3 = "Request ECUReset for [*11 01 10]";
    String output3 = input3.substring(input3.indexOf("[*")+"[*".length(), input3.indexOf("]", input3.indexOf("[*")));
    System.out.println(input3 + " --> " + output3);
}