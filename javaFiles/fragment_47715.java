public static float secondHighest(Float[] arr) {
        float largest = arr[0];
        float secondLargest = Float.NEGATIVE_INFINITY;
        boolean foundSecondLargest = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
                foundSecondLargest = true;
            } else if ( arr[i] != largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
                foundSecondLargest = true;
            }
        }
        if ( !foundSecondLargest )
            secondLargest = 0.0F;
        System.out.println( String.format("%.2f", secondLargest ) );
        return secondLargest;
    }