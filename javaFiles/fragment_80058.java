List<Integer> l =  Collections.synchronizedList(new LinkedList<>());

    // Make the list visible to other threads ...

    for (int i = 0; i < l.size(); i++) {
        Integer ii = l.get(i);
        ...
    }