static int getClosestToZero(int[] array)
{
    int num = array[0];
    int absNum = Math.abs(num);
    for (int i = 1; i < array.length; ++i)
    {
        int newAbs = Math.abs(array[i]);
        if (newAbs < absNum)
        {
            absNum = newAbs;
            num = array[i];

        }else if(newAbs == absNum && array[i]>=0)//if equals and the current is positive, then take it
        {
                num = array[i];
        }
    }

    return num;
}