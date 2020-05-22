LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(4);
        list.add(12);
        list.add(3);
        list.add(7);
        Collections.sort(list);
        list.removeFirst();
        list.forEach(System.out::println);