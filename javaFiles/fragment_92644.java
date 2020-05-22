do {
    c = rand.nextInt(20 - 1) + 1;
    d = rand.nextInt(20 - 1) + 1;
} while (c%d != 0);
System.out.println(c);
System.out.println(d);
System.out.println(c / d);