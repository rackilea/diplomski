for(String s : colls)
        {
            DBCollection coll = db.getCollection(s);
            DBCursor whatIHaveBeenLookingFor = coll.find(
                new BasicDBObject().append("LoginRequest",
                new BasicDBObject().append("Time", dayToSearch)));
        }