int adjacent=0;

for(int i =0; i<6; i++)
{
    test[i]=(int)(45*Math.random())+1;
    int t = -1;
    //Make sure this comparison only happens after the second iteration
    //to avoid index out of bounds
    if ( i != 0 ) 
    {
        //Set t to the last number + 1 instead of trying to predict the future
        t = test[i-1] + 1;
    }
    //Now this comparison makes a little more sense
    //The first iteration will compare to -1 which will always be false
    if(test[i]==t)
        adjacent++;

    System.out.print(test[i]+"    ");
}