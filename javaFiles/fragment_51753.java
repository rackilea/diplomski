public static int [] add(int [] array1){
        array1 = new int [array1.length];
        int [] array2 = new int[array1.length];

        for(int i = 0; i < array1.length; i++){
            array2[i] = array1[i] + 1;
        }

        return array2;
    }