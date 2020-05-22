do {
    TwitterResponse response = twitter.getFollowersIDs(userId, cursor);
    RateLimitStatus status = response.getRateLimitStatus();
    if(status.getRemaining() == 0) {
        try {
            Thread.sleep(status.getSecondsUntilReset() * 1000);
        }
        catch(InterruptedException e) {
            // ...
        }
    }
} while(cursor > 0);