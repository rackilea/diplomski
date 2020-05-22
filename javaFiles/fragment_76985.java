int day = 0;
System.out.println("Day " + day + " " + Arrays.toString(inhabitants));
while (!Arrays.stream(inhabitants).allMatch(x -> x == 0)) {
    day++;
    for (int i = 0; i < inhabitants.length; i++) {
        inhabitants[i] /= 2;
    }
    System.out.println("Day " + day + " " + Arrays.toString(inhabitants));
}
System.out.println("---- EXTINCT ----");