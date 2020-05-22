public void test5(){
    Scanner scan = new Scanner(System.in);
    int[] arr = new int[10];
    for (int i = 0; i< 10; i++) {
        System.out.println("Please enter an Integer:");
        arr[i]=scan.nextInt();
    }
    scan.close();
    //To check array output
    for(int a:arr){
      System.out.println(a);
    }
}