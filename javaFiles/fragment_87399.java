Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

// Loop through the table and assign the
// key/value to be checked and added to your map
... 

if(map.containsKey(key))
{
    map.get(key).add(value);
}
else
{
    ArrayList<String> newValueList = new ArrayList<String>();
    newValueList.add(value);

    map.put(key, newValueList);
}