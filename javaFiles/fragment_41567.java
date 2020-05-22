Scanner in = new Scanner(System.in);
while (in.hasNextInt()) {
    int inputLine = in.nextInt();
    String v = Integer.toString(inputLine), f = v.substring(0, 1);
    System.out.println(f + v.substring(1).replaceAll(f, "*"));
}