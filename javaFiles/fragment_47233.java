List<Integer> list = new ArrayList<Integer>();

    list.add(1); 
    list.add(4);
    list.add(2);
    list.add(3);
    System.out.println("Original List: " + list);

    Collections.shuffle(list);

    System.out.println("Shuffled List: " + list);
    int number1 = list.remove(0);  // Remove the first value
    System.out.println("Number removed: " + number1);

    Collections.shuffle(list);

    System.out.println("Shuffled List: " + list);
    number1 = list.remove(0);
    System.out.println("Number removed: " + number1);