String[][] output = Arrays.stream(input)
            .collect(Collectors.groupingBy(a -> a[0], Collectors.averagingDouble(a -> Double.parseDouble(a[1]))))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .map(ar -> new String[] { ar.getKey(), String.format( "%.2f", ar.getValue()) })
            .toArray(String[][]::new);

    System.out.println(Arrays.deepToString(output));  //[[Ann, 5.00], [Tom, 3.50]]