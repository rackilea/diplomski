int num = 1;
    //print the 1st element
    System.out.println(num + "  " + array[0]);
    for (int a = 1; a < array.length; a++) {
        num++;
        System.out.print(num + "  " + (array[a]));
        //plz note that we check with the before, not after
        if (array[a] < array[a - 1]) {
            down++;
        } else if (array[a] > array[a - 1]) {
            up++;
        } else {
            same++;
        }
        //changed down > to down ==
        if ((up >= 3 && (down == 1 || same >= 1))) {
            System.out.print("  " + "sell");
            up = 0;
            same = 0;
        } 
        //changed up > to up ==
        else if ((down >= 3 && (up == 1 || same >= 1))) {
            System.out.print("  " + "buy");
            down = 0;
            same = 0;
        }
        System.out.println();
    }