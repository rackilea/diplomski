....
    List<Integer> list = new ArrayList<Integer>();

    Scanner scanner = new Scanner(new File("resources/abc.txt"));
    while (scanner.hasNextInt()) {
        list.add(scanner.nextInt());
    }

    Integer[] numArray = list.toArray(new Integer[] {});

    Arrays.sort(numArray);
    ....