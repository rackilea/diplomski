List<Integer> integerList = new ArrayList<Integer>() {{
    add(1);
    add(2);
    add(3);
    add(4);
    add(5);
    add(6);
    add(7);
    add(8);
    add(9);
    add(10);
}};

for (ListIterator<Integer> iterator = integerList.listIterator(); iterator.hasNext(); ) {
    int value = iterator.next();
    int nextValue = Integer.MIN_VALUE;
    if (iterator.hasNext()) {
        nextValue = iterator.next();
        // Reset the state of the iterator
        iterator.previous();
    }

    System.out.println("Value = " + value);
    if(nextValue != Integer.MIN_VALUE) {
        System.out.println("Next value = " + nextValue);
    }
}