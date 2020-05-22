public static void main(String[] args)
{
    int count = 0;
    accnums = new Integer[] {1,2,null,null,null};
    for (int index = 0; index < accnums.length; index++) 
    {
        if(accnums[index] != null)
        {
            count++;
        }
    }

    System.out.println("You have used " + count + " slots);

}