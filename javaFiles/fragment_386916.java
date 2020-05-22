final DBObject userId = new BasicDBObject("user.id", id);
final DBObject retweetedStatusUserId = new BasicDBObject("retweeted_status.user.id", id);
final DBObject or = new BasicDBObject("$or", Arrays.asList(userId, retweetedStatusUserId));

final DBObject greaterThan = new BasicDBObject("$gt", dateFrom);
final DBObject datePostedGreaterThan = new BasicDBObject("date_posted", greaterThan);
final DBObject lessThan = new BasicDBObject("$lt", dateTo);
final DBObject datePostedLessThan = new BasicDBObject("date_posted", lessThan);
final DBObject and = new BasicDBObject("$and", Arrays.asList(datePostedGreaterThan, datePostedLessThan));

final DBObject query = new BasicDBObject("$and", Arrays.asList(or, and));