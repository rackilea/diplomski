public static String commas(long input) {
        if (input < 1000) {
            return String.valueOf(input);
        } else {
            long pt1Number = input / 1000;
            long pt2Number = input % 1000;
            return commas(pt1Number) + ","
                   + (pt2Number==0l?"000":String.valueOf(pt2Number));
            }

    }