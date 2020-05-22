int size = 3;
    int values = 1;
    for (int i = 0; i < size; i = i + 3) {
        int[] arr = new int[size];
        for (int j = 0; j < size; j++) {
            arr[j] = values;
            values++;
        }
        size += 3;
        int count = 0;
        for (int j : arr) { // for display
            ++count;
            System.out.print(j);
            if (count != arr.length) {
                System.out.print(" , ");
            }
        }
        System.out.println();

        if (i > 6) { // to put an end to endless creation of arrays
            break;
        }

    }