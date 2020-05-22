for(int i = 1; i <= size; i++)
    {
        // Using a single for to make sure we don't create too many items.
        // Also note the +1. It seems that when size = 3, you want 4 chars
        // per line, so this take that extra char into account.
        for(int k = 0; k < size + 1; k++)
        {
            // Use an if to decide if we print * or #.
                // As 'i' gets bigger, we need to put less *, so
                // we subtract 'i' from the total size. This tells
                // when the midpoint has passed and we should start
                // writing #s.
            if (k <= size - i)
                output += "*";
            else
                output += "#";
        }

        output += "\n"; 
    }