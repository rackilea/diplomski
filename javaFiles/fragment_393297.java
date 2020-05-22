for(j = 2; j < array.length - 2; j++)
    {
        for(int k = -2; k <= 2; k++)
        {
            newArray[j] += array[j+k] / 5;  
        }

    }