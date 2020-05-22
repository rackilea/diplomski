String input = "1 fish 2 fish red sheep blue sheep";
Pattern animal = Pattern.compile("\\s*(fish|sheep)\\s*");
Scanner sc = new Scanner(input);

while (sc.hasNext()) {
    System.out.println(sc.next());
    System.out.println(sc.next(animal));
}