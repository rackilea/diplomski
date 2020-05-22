class JSONComparator implements Comparator<JSONObject>
{

    public int compare(JSONObject a, JSONObject b)
    {
        //valA and valB could be any simple type, such as number, string, whatever
        String valA = a.get("keyOfValueToSortBy");
        String valB = b.get("keyOfValueToSortBy");

        return valA.compareTo(valB);
        //if your value is numeric:
        //if(valA > valB)
        //    return 1;
        //if(valA < valB)
        //    return -1;
        //return 0;    
    }
}