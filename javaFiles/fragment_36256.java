final int NUMB_ITEMS = 4;
int[] itemAmounts = new int[NUMB_ITEMS];
int c = 0;
int x = 0;
while(x!=-1 && c < NUMB_ITEMS){
    System.out.print("Enter the number of Item "+(c+1)+" you would like to purchase: ");
    int x = input.nextInt();
    itemAmounts[c] = x;
    c++;
}