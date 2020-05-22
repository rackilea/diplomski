HashSet<Integer> set = new HashSet<Integer>();
    Random random = new Random();
    int i = 0;

    while(set.size() < 10){
        set.add(random.nextInt(40) + 1);
        i++;
    }

    System.out.println(set);
    System.out.println(i);