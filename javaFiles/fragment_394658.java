for(int i = 1; i <= size; i++)
    {
        // Adds a number of * inversely proportional to the current
        // value of 'i'.
        for(int k = 0; k <= size - i; k++)
        {
            output += "*";
        }

        // Start adding # where we stopped the *.
        for(int j = size - i; j < size; j++)
        {
            output += "#";
        }

        output += "\n"; 
    }