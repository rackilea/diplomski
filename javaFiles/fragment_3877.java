Set<Integer> numbers = new TreeSet<Integer>();

    numbers.add(2);
    numbers.add(5);

    System.out.println(numbers); // "[2, 5]"
    System.out.println(numbers.contains(7)); // "false"

    System.out.println(numbers.add(5)); // "false"
    System.out.println(numbers.size()); // "2"

    int sum = 0;
    for (int n : numbers) {
        sum += n;
    }
    System.out.println("Sum = " + sum); // "Sum = 7"

    numbers.addAll(Arrays.asList(1,2,3,4,5));
    System.out.println(numbers); // "[1, 2, 3, 4, 5]"

    numbers.removeAll(Arrays.asList(4,5,6,7));
    System.out.println(numbers); // "[1, 2, 3]"

    numbers.retainAll(Arrays.asList(2,3,4,5));
    System.out.println(numbers); // "[2, 3]"