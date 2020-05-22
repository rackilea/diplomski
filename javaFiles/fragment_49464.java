List<Integer> pennies = new ArrayList<>(NUMBER_OF_PENNIES);
    for (int p = 0; p < NUMBER_OF_PENNIES; p++) {
        Integer penny;
        do {
            int a = gen.nextInt(5);
            int b = gen.nextInt(5);
            penny = pArray[a][b];
        } while (pennies.contains(penny));
        pennies.add(penny);
    }