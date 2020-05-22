ArrayList<Integer> itemAmounts = new ArrayList<Integer>();
int c = 1;
int x = 0;
while(x!=-1){
    System.out.print("Enter the number of Item "+c+" you would like to purchase: ");
    int x = input.nextInt();
    itemAmounts.add(x);
    c++;
}