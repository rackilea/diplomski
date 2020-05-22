public static void main (String[]args){
    int[] myArray = {1,8,3,0,2};

    for(int n=myArray.length; n>1; n=n-1){
        System.out.println("Outer loop: " + n);
        for(int i=0; i<myArray.length-1; i++){
            if(myArray[i]<myArray[i+1]){
            }
            else{
                int temp=myArray[i];
                myArray[i]=myArray[i+1];
                myArray[i+1]=temp;
            }
            System.out.println(Arrays.toString(myArray));
        }   
    }
}