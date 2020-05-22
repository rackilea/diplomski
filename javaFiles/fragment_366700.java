public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    int[] arr1 = new int[4];
    int[] arr2 = new int[3];
    int[] arr3 = new int[arr1.length + arr2.length];

    for (int i = 0; i < arr1.length; i++) {
        try {
            if (input.hasNext()) {
                arr1[i] = input.nextInt();
            }
        }catch (Exception e) {
        }

        System.arraycopy(arr1, 0, arr3, 0, arr1.length);  
    }

     Scanner input2 = new Scanner(System.in);

     for (int i = 0; i < arr2.length; i++) {
        try {
            if (input2.hasNext()) {
                arr2[i] = input2.nextInt();
            }
        }catch (Exception e) {
        }

        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
     }


     for (int a = 0; a < arr3.length; a++) {
        if(arr3[a] != 0)
            System.out.print(arr3[a] + " ");
     }
}