public class MapAdaptor extends XmlAdapter<Pair[], Map<String, String>> 
{
    @Override
    public Map<String, String> unmarshal(Pair[] list) throws Exception 
    {
        Map<String, String> retVal = new HashMap<String, String>();
        for (Pair keyValue : Arrays.asList(list)) 
        {
            retVal.put(keyValue.getKey(), keyValue.getValue());
        }
        return retVal;
    }

    @Override
    public Pair[] marshal(Map<String, String> map) throws Exception 
    {
        List<Pair> retVal = new ArrayList<Pair>();
        for (String key : map.keySet()) 
        {
            retVal.add(new Pair(key, map.get(key)));
        }
        return retVal.toArray(new Pair[]{});
    }
}