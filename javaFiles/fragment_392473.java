public static void main(String[] args) {
     Integer[] arr = new Integer[5];
     arr[0] = 23;
     arr[1] = 123;
     arr[2] = 255;

     printArray(arr);
}

public static void printArray(Integer... arr){
    for(Integer t : arr) {
        if (t != null) {
            System.out.println(t);
        }
    }
}