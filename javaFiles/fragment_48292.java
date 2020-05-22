int adjacent=0;

for(int i =0; i<6; i++)
{
    //test[i] hasn't been set yet
    int t = test[i]+1;
    test[i]=(int)(45*Math.random())+1;

    //this comparison doesn't make a whole lot of sense
    if(test[i]==t)
        adjacent++;

    System.out.print(test[i]+"    ");
}