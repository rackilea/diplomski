BasicDBObject query = new BasicDBObject("_sensor", getFieldValue);
DBCursor cursor = coll.find(query);
List<String> v = null;

try 
{
    while (cursor.hasNext()) 
    {
        v = new ArrayList<String>();
        DBObject theObj = cursor.next();
        BasicDBObject valueField = (BasicDBObject) theObj.get("values");

        Set<String> keys = valueField.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) 
        {
            v.add(valueField.getString(iter.next()));
        }
        System.out.println(v);
    }
} 
finally 
{
    cursor.close();
}