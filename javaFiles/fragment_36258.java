int item1Amount;
int item2Amount;
int item3Amount;
int item4Amount;
int c = 1;
int a = 0;
while(x!=-1 && c<= 4){
    System.out.print("Enter the number of Item "+c+" you would like to purchase: ");
    a=input.nextInt();
    if(c == 1){
        item1Amount = a;
    } else if(c == 2){
        item2Amount = a;
    } else if (c == 3){
        item3Amount = a;
    } else if (c == 4) {
        item4Amount = a;
    }
    c++;
}