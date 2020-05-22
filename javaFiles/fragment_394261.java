public Map<Object, Integer> countDuplicates(Object anArray)
{
    if (!anArray.getClass().isArray())
        throw new IllegalArgumentException("anArray is not an array");

    Map<Object,Integer> dedup = new HashMap<Object,Integer>();
    int length = Array.getLength(anArray);
    for (int i=0; i<length; i++)
    {
        Object value = Array.get(anArray, i);         
        Integer count = dedup.get(value);
        dedup.put(value, count==null ? 1 : count+1);
    }
    return dedup;
}