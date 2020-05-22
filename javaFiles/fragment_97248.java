private static int powerOf2(int aNumber)
{
    int power = 0;
    if(aNumber % 2 != 0)
    {
        return -1;
    }
    else
    {
        System.out.print(aNumber + " is 2 raised to ");
        while (true)
        {
            if(aNumber % 2 == 0){
            aNumber /= 2;
            power++;
            if(aNumber == 1) return power;
            }else{
                return -1;
            }

        }

    }
}