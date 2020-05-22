BasicDBObject keys = new BasicDBObject();
keys.put("symbol", 1 );
keys.put("price", 1 );
keys.put("Exchange", 1);

BasicDBObject search = new BasicDBObject();
search.put("Exchange", "SH");
search.put("numShares", new BasicDBObject("$gte", 0) );

DBCursor cursor_02 = coll_tmp.find(search, keys);