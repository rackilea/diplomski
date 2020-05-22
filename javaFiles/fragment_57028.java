while (sc.hasNext()) {
        String Str = sc.next();
        String[] num = Str.split(",");

        int[] Num = new int[num.length];
        for (int i = 0; i < Num.length; i++) {
            Num[i] = Integer.parseInt(num[i]);
        }

        if (Num[0] < Num[1] && Num[1] < Num[2] && Num[2] < Num[3]
                && Num[3] < Num[4] && Num[4] < Num[5] && Num[5] < Num[6]
                && Num[6] < Num[7] && Num[7] < Num[8] && Num[8] < Num[9]) {
            System.out.println("The array is growing.");
        } else if (Num[0] > Num[1] && Num[1] > Num[2] && Num[2] > Num[3]
                && Num[3] > Num[4] && Num[4] > Num[5] && Num[5] > Num[6]
                && Num[6] > Num[7] && Num[7] > Num[8] && Num[8] > Num[9]) {
            System.out.println("The array is decreasing.");
        } else if (Num[0] == Num[1] && Num[1] == Num[2] && Num[2] == Num[3]
                && Num[3] == Num[4] && Num[4] == Num[5] && Num[5] == Num[6]
                && Num[6] == Num[7] && Num[7] == Num[8] && Num[8] == Num[9]) {
            System.out.println("The array is constant.");
        } else {
            System.out.println("The array is growing and decreasing.");
        }
    }