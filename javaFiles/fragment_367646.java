public static void main(String arg[])
{
    int array[]=new int[80];

    //filling array upto 80
    for(int i=0;i<=79;i++) 
        array[i]=i+1;

    //display array on console
    int counter=0;
    for(int i=0;i<=79;i++)
    {
        counter++;
        System.out.print(array[i]+" ");

        if(counter==10)
        {
            /*printing new line
            after counting upto 10 elements*/
            System.out.println(); 

            //reseting counter to 0;
            counter=0;
        }
    }
}