int[] list = new int[10];
    int duplicates = 0;
    Random random = new Random();
    for (int i = 0; i < list.length; i++) {
        int nextVal = random.nextInt(list.length);
        System.out.println("list["+i+"] = "+ nextVal);
        // test duplicates
        for (int index = 0; index < i; index++) {
            if (list[index] == nextVal) {
                duplicates++;
                break;
            }
        }
        list[i] = nextVal;
    }
    return duplicates;