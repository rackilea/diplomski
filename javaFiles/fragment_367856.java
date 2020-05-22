final QueryResult result = twitter.search(query); // 100 Tweets

final Status lastStatus = getLast(result.getTweets());

query.sinceId(lastStatus.getId());
final QueryResult nextResult = twitter.search(query); // Another 100 Tweets

// and so on...