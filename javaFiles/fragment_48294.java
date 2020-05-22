int adjacent=0;

for(int i =0; i<6; i++)
{
    test[i]=(int)(45*Math.random())+1;

    if(i != 0 && test[i]==(test[i-1]+1))
        adjacent++;

    System.out.print(test[i]+"    ");
}