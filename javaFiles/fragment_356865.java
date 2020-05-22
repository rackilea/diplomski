Stack<Integer> intStack = new Stack<>();
    int d = 123;
    for (int i = 1; i <= d; i++) 
    {
        if (d % i == 0) 
        {
            intStack.push(i);
        }
    }
    while (!intStack.isEmpty())
    {
        System.out.println(intStack.pop());
    }