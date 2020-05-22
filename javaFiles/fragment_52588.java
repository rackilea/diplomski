DBCollection myColl = ds.getCollection(MessageEntry.class);
    DBObject key = new BasicDBObject("linf",true);
    DBObject initial = new BasicDBObject("cnt",true);
    String reduce = "function(item,prev){prev.cnt+=1;}";

    DBObject group = myColl.group(key, null, initial, reduce);

    HashMap<String,Long> ret = new HashMap();
    for(String k:group.keySet()){
        BasicDBObject l = (BasicDBObject) group.get(k);
        DBRef dbRef = (DBRef) l.get("linf");
        Linf linf = ds.get(Linf.class,dbRef.getId() );
        Double cnt = (Double) l.get("cnt");
        ret.put(linf.limad,cnt.longValue());
    }
    return ret;