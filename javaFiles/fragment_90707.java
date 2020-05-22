public static void shuffle(Person[] arr) {
        Random rgen = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randPos = rgen.nextInt(arr.length);
            Person tmp = arr[i];
            arr[i] = arr[randPos];
            arr[randPos] = tmp;
        }
    }