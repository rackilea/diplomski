private ArrayList<HashMap<String, String>> sortArrayMap2(ArrayList<HashMap<String, String>>  arrList)
{
    ArrayList<HashMap<String, String>> retArray = new ArrayList<HashMap<String, String>>();
    HashMap<String, Integer> tableUnOrdered = new HashMap<String,Integer>();

    for (int i = 0; i < arrList.size(); i++)
    {
        HashMap<String, String> map = arrList.get(i);

        tableUnOrdered.put(map.get("TCNT"), i);
    }
    Vector<String> v = new Vector<String>(tableUnOrdered.keySet());
    Collections.sort(v);
    for (int j = 0; j < MAX_ITEMS_PER_GRAPH && j < v.size(); j++)
        retArray.add(v.get(j)); // add the list in the needed order

    return retArray;
}