List<List<String>> input = new LinkedList<List<String>>(Arrays.asList(
            Arrays.asList("Cat", "Mouse", "Dog"),
            Arrays.asList("Dog", "Mouse", "Cat"),
            Arrays.asList("Dog", "Horse", "Cat"),
            Arrays.asList("Dog", "Tiger", "Lion")));

    Set<Set<String>> distinctElements = new HashSet<Set<String>>();

    for (Iterator<List<String>> iterator = input.iterator(); iterator.hasNext(); ) {
        List<String> element = iterator.next();
        HashSet<String> elementAsSet = new HashSet<String>(element);
        if (!distinctElements.contains(elementAsSet)) {
            distinctElements.add(elementAsSet);
        } else {
            iterator.remove();
        }
    }

    System.out.println(input);