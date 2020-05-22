Arrays.sort(whitelist);
    int newArray[] = new int[whitelist.length];
    newArray[0] = whitelist[0];
    int k = 1;
    for (int i = 0; i < whitelist.length - 1; i++) {
        if(whitelist[i+1] > whitelist[i]) {
            newArray[k] = whitelist[i + 1];
            k++;
        }
    }
    newArray = Arrays.copyOf(newArray, k);
    whitelist = newArray;
    System.out.println(Arrays.toString(newArray));