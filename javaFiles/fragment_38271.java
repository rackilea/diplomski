int arr[] = new int[10000];
Random rand = new Random();

for (int i=0; i<10000; i++){
    arr[i] = rand.nextInt( 100 ) + 1;
}
Arrays.sort(arr);
System.out.println(Arrays.toString(arr));