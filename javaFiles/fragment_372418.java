ArrayList list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(3);

    BasicDBObject doc = new BasicDBObject("_id", "ArrayList").append("data", list);

    coll.insert(doc);