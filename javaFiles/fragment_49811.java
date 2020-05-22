int[] myIntArray = new int[20];
    Random r = new Random();

    for (int i = 0; i < myIntArray.length; i++) {
        int rand = r.nextInt(80 - 25) + 25;
        myIntArray[i] = rand;
    }

    for (int i = 0; i < myIntArray.length; i++) {
        System.out.println(myIntArray[i]);
    }