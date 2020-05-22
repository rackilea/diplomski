public static int [] answer (int [] data, final int maxInstances)
{
    if (data.length >= 100)
    {
        throw new IllegalArgumentException("Too many IDs!");
    }
    else
    {
        // build a frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int e : data)
        {
            Integer val = frequencyMap.get(e);
            if (val == null)
                frequencyMap.put(e, 1);
            else
                frequencyMap.put(e, val + 1);
        }

        // build a list with the values that appear no more than maxInstances
        List<Integer> newData = new ArrayList<>();
        for (int e : data)
        {
            if (frequencyMap.get(e) <= maxInstances)
                newData.add(e);
        }

        // convert the list to an int []
        int [] ret = new int[newData.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = newData.get(i);

        return ret;
    }
}