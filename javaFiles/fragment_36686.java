// 3.x driver idiom
Bson filter = Filters.eq("_id.timeSlice", Arrays.asList(2018, 5, 1));

// 2.x driver idiom
// Bson filter = new BasicDBObject("_id.timeSlice", Arrays.asList(2018, 5, 1));

collection.find(filter);