StringBuilder numbers = new StringBuilder();

    int[] num = new int[9];
    for (int i = 0; i < num.length; i++) {
        num[i] = i;

        numbers.append(i);
    }

    long a = Long.valueOf(numbers.toString());

    System.out.println(a);