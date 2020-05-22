ListIterator<Integer> iterator = history.iterator();
    while(iterator.hasNext()) {
        int a = iterator.next();
        System.out.println(a);
        if (a % 3 == 1) {
            System.out.println(iterator.previous());
        }

    }