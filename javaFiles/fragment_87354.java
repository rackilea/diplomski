public class MapAdaptor extends XmlAdapter<PairList, Map<String, String>> 
{
    @Override
    public Map<String, String> unmarshal(PairList list) throws Exception 
    {
        Map<String, String> retVal = new HashMap<String, String>();
        for (Pair keyValue : list.getValues()) 
        {
            retVal.put(keyValue.getKey(), keyValue.getValue());
        }
        return retVal;
    }

    @Override
    public PairList marshal(Map<String, String> map) throws Exception 
    {
        PairList retVal = new PairList();
        for (String key : map.keySet()) 
        {
            retVal.getValues().add(new Pair(key, map.get(key)));
        }
        return retVal;
    }
}