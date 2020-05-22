long array_sum(int...array)
    {
        long sum = 0;
        for(int value : array)
            sum += value;
        return sum;
    }