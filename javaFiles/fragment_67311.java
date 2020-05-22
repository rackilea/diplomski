String regex = "123[4-6][7-9]"; 
    Xeger generator = new Xeger(regex);
    Set<String> generated = new HashSet<>();
    for (int i = 0; i < 100; i++) {
        generated.add(generator.generate());
    }
    System.out.println(generated);

    //[12367, 12348, 12359, 12349, 12357, 12368, 12369, 12347, 12358]