Scanner src = new Scanner(is);
while (src.hasNext()) {

    int line = src.nextInt();
    String value = src.next();

    System.out.println(line + " = " + value);

}