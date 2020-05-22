BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("employeeID", "101");
        String date_string = "2015-04-17 11:02:49";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date date = format.parse(date_string);
        whereQuery.put("start_time", new BasicDBObject("$lt", date));
        whereQuery.put("end_time", new BasicDBObject("$gt", date));
DBCursor cursor = col.find(whereQuery);