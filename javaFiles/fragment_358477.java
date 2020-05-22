Comparator<Map<String, String> comparator = new Comparator<Map<String, String>()
{
    public int compare(Map<String, String> o1, Map<String, String> o2) 
    {
        return o1.get("name").compartTo(o2.get("name");
    }
}

Collections.sort(groupData, comparator);