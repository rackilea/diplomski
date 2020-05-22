int list[] = new int[] { 200, 8, 10, 60, 30, 80 };
    int length = list.length;
    int value = 50;
    int temp;
    int actual_i = 0;
    // System.out.println(length);
    for (int i = 0; i < list.length; i++) {
        if (list[i] < value && actual_i < list.length - 1) {

            int remIndex = i;
            temp = list[i];
            // System.out.println(remIndex);
            // System.out.println(temp);

            for (int j = remIndex; j < list.length - 1; j++) {
                list[j] = list[j + 1];

            }
            list[list.length - 1] = temp;
            i--;
        }
        actual_i++;

    }
    for (int i = 0; i < list.length; i++) {
        System.out.println(list[i] + "");
    }