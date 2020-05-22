public static void main(String[] args) {
    String s = "abc def, ghi klm";
    Pattern p = Pattern.compile("[^,] ");
    Matcher m = p.matcher(s);

    int count = 0;
    while (m.find())
        count++;

    System.out.println(count); //prints 2
}