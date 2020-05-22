try (Scanner scan = new Scanner(System.in)) {
    int i = 0;

    while (i < animals.size()) {
        if (scan.nextInt() == 2)
            System.out.println(animals.get(i++));
    }
}