//create list with 3 dimensions using Guava
    List<Integer> dims = ImmutableList.of(1000, 1000, 1000);
    //or with standard JDK
    //List<Integer> dims = new ArrayList<Integer>(3);dims.add(1000);dims.add(1000);dims.add(1000);

    System.out.println(nthElement(dims, 0));
    System.out.println(nthElement(dims, 1000));
    System.out.println(nthElement(dims, 1001));
    System.out.println(nthElement(dims, 2001));