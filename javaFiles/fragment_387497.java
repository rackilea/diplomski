Set<Set<Integer>> solutions = new HashSet<>();
    for (int i: ts)
    {
        for (int j : ts.tailSet(i, false))
        {
            valueSearching = sumSearching - (i + j);
            if (valueSearching != i && valueSearching != j)
                if (ts.contains(valueSearching)) {
                    Set<Integer> solution = new TreeSet<>();
                    Collections.addAll(solution, i, j, valueSearching);
                    if (solutions.add(solution)) {
                        System.out.println("Solution: "
                                + i + ", " + j + ", " + valueSearching);
                    }
                }
        }
    }