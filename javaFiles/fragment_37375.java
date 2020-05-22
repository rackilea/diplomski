Comparator<TreeSet<?>> compareBySize 
            = Comparator.comparing((TreeSet<?> s) -> s.size())
                    .thenComparing(TreeSet::toString);

    TreeSet<TreeSet<Character>> mySet = new TreeSet<>(compareBySize);
    mySet.addAll(Arrays.asList(
                new TreeSet<>(Arrays.asList('A', 'B', 'E')),
                new TreeSet<>(Arrays.asList('A', 'C', 'F')),
                new TreeSet<>(Arrays.asList('B', 'D', 'F')),
                new TreeSet<>(Arrays.asList('A')),
                new TreeSet<>(Arrays.asList('A', 'B', 'E'))
            ));
    System.out.println(mySet);