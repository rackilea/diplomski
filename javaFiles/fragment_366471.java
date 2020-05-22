List<Integer> xList = Arrays.asList(4,6,9,9);
    List<Integer> yList = Arrays.asList(4,5,8,11);
    List<Integer> result = new ArrayList<Integer>();

    result.addAll(xList);
    result.addAll(yList);

    System.out.println("Before sorting-->" +result );

    Collections.sort(result);
    System.out.println("After sorting-->" +result );