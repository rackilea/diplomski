// flag to control if you want number sequence to be the same each run
    boolean repeatable = true;

    // seed for randomness - for permutation of list (not the integers)
    Random rnd = new Random((repeatable ? 3 : System.currentTimeMillis()));

    // generate randomized sequence as a List
    List<Integer> myNums;
    Collections.shuffle((myNums = IntStream.rangeClosed(1000, 9999).boxed().collect(Collectors.toList())), rnd);

    // Work with list...
    for (Integer somePin : myNums) {
        Log.i("", "Next PIN: "+somePin);
    }