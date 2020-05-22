int[] test={10212,10202,11000,11000,11010};
ArrayList<Integer> test2 = new ArrayList<Integer>();


for(int i = test.length -1; i >= 0; i--){
    int temp = test[i];
    while(temp>0){
        test2.add(0, temp%10);  //place low order digit in array
        temp = temp /10;        //remove low order digit from temp;
    }
}