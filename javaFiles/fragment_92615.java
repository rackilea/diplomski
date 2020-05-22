private static void rotateArray(int[] arr,int m){
        int left = 0,right = arr.length - 1;
        int limit = Math.min(m,arr.length/2);
        while(left < limit){
            swap(arr,left++,right--);
        }

        reverse(arr,arr.length - m,arr.length-1);
        reverse(arr,m,arr.length-m-1);
        reverse(arr,0,arr.length-m-1);
    }

    private static void reverse(int[] arr,int left,int right){
        while(left < right){
           swap(arr,left++,right--);
        }
    }

    private static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }