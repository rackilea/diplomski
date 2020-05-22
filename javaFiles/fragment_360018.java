private static boolean exist(DBCollection coll, String key)
{
    DBObject query = new BasicDBObject("token", new BasicDBObject( "$ne", "").append("$exists", true)).append("_id", key);

    return coll.count(query) == 1;      
}

exist(coll, "abc@gmail.com"); // true
exist(coll, "jkl@gmail.com"); // false