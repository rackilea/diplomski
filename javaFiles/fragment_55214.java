List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    triangle.add(Arrays.asList(75));
    triangle.add(Arrays.asList(95, 64));

    for (List<Integer> row : triangle) {
        // you can also ask for row.indexOf(max);
        System.out.println("At row: " + triangle.indexOf(row) + " is: " + row.indexOf(64));         
    }