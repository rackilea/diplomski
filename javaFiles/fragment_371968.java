long count = 1L * MAX * MAX * MAX * MAX * MAX; // one more * MAX

    ...

    int[] digits = new int[5]; // from [4]
    char[] output = "00000".toCharArray(); // from 0000

    ...

            for(int d =  4; d >=0; --d){ // from d = 3