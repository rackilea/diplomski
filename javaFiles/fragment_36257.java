int item1Amount;
int item2Amount;
int item3Amount;
int item4Amount;
int c = 1;
int a = 0;
while(x!=-1 && c<= 4){
    System.out.print("Enter the number of Item "+c+" you would like to purchase: ");
    a=input.nextInt();
    switch(c){
        case 1:
            item1Amount = a;
            break;
        case 2:
            item2Amount = a;
            break;
        case 3:
            item3Amount = a;
            break;
        case 4:
            item4Amount = a;
            break;
        default:
            break;
    }
    c++;
}