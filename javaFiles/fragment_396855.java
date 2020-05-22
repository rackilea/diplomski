public static int functionBottomUp (int n){
        int [] array = new int[n+1];
        array[0] = 1;
        for(int i = 1; i < array.length; i++){
            if(i == 1)
                array[i] = array[i - 1];
            else {
                for(int p = 0; p < i; p ++)
                    array[i] += array[p];
            }
        }
        return array[n];
}