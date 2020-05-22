Scanner sc = new Scanner(System.in);
Pattern newlineOrSpace = Pattern.compile(System
        .getProperty("line.separator") + "|\\s");
sc.useDelimiter(newLineOrSpace);
List<Double> numbers = new ArrayList<Double>();
System.out.println("Enter numbers:");
while (sc.hasNextDouble()) {
    numbers.add(sc.nextDouble());
}
for (Double number : numbers) {
    System.out.println(number);
}