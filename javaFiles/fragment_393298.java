for(int i = 2; i < array.length - 2; i++)
    {
        if(array[i] > (newArray[i] + 0.999))
        {
            count++;
            tempVal = count;
        }

        System.out.println(tempVal);
    }