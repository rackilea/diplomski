public static void main(String [] args){
    int [] a = {45,23,4,6,2};
    for(int i = 0; i< a.length; i++){
        for(int j = i; j>0; j--){
            if(a[j]< a[j-1]){
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }
    // Arrays.stream(a).forEach(System.out::println); -- Java 8
   for (int idx = 0; idx < a.length; idx++) {
      System.out.println(a[idx]);
   }
}