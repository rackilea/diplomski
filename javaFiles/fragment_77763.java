List<List<Integer>> result = Arrays.asList(
                       Arrays.asList(7), 
                       Arrays.asList(1, 2, 3), 
                       Arrays.asList(1, 2, 4), 
                       Arrays.asList(1, 2, 5))
            .stream()
            .filter(inner -> inner.stream().anyMatch(x -> x == 5))
            .collect(Collectors.toList());

    System.out.println(result); // only the one that contains "5"[[1,2,5]]