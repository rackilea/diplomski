public static int[] sortlowhigh(int a[])
    {
        int i = 0;
        int j = 0;
        int temp;
        while(j< (a.length -1) ){
           i = 0;
            while(i< (a.length - j - 1)){
                if (a[i] > a[i+1]){
      /* store low  value in temp*/
                    temp = a[i];
      /* assign low value  to be the higher value*/
                    a[i] = a[i+1];
      /* assign the old higher value to be the lower value stored in temp*/
                    a[i+1]=temp;
                }
               i++;
            }
            j++;
        }
        return a;
    }