Scanner s = new Scanner(System.in);
    System.out.println("please enter 5 records");
    List<Dinosaur> dinoList = new ArrayList<Dinosaur>();

    for (int i = 0; i < 5; i++) {
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        Dinosaur d = new Dinosaur(num1, num2);
        dinoList.add(d);

    }