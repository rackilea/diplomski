public static void main(String[] args) {
        int arr1[]={8,4,6,8,4};
        int arr2[]={2,4,2,1,2};

        for (int i=0; i<arr1.length; i++){
            for (int j =0;j<arr2.length;j++){
                int result = arr1[i] / arr2[j];

                System.out.println(result);

            }
        }
    }