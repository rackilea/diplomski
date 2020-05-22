//lets say we have these three numbers:
    int num1 = 2, num2 = 5, num3 = 3;

    List<Integer> list = new ArrayList<Integer>();
    list.add(num1);
    list.add(num2);
    list.add(num3);

    System.out.println(list);

    Collections.sort(list);

    System.out.println(list);