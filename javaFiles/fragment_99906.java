public static void main(String[] args) {
    String a = "0700";
    Scanner s = new Scanner(a);
    while (s.hasNextLong(8)) { //make sure the number can be parsed as an octal
        System.out.print(s.nextLong(8)); //read as an octal value
    }
}