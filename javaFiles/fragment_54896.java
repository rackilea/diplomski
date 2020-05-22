while (fibNum < 144)
    {
        int lastValue = (Integer) fibList.get(fibList.size()-1);
        int secondToLastValue = (Integer) fibList.get(fibList.size()-2);

        fibNum = secondToLastValue + lastValue;

        if (fibNum < 144)
        {
            fibList.add(fibNum);
        }
    }

    //Picks out the even numbers from limitFibList
    for (int i = 0; i < fibList.size(); i++)
    {...