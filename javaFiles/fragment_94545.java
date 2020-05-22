public enum UserStore {
    ;

    interface User {
        String getUserId();
    }

    // a LRU cache with a timestamp.
    private static final Map<String, TimeStampedToken<User>> tokenMap = new LinkedHashMap<String, TimeStampedToken<User>>(16, 0.7f, true);
    private static final long OBJECT_LIVE_TIME = 299900;

    public static synchronized void addToken(User tok) {
        final long now = System.currentTimeMillis();
        // clean up as we go
        for (Iterator<Map.Entry<String, TimeStampedToken<User>>> iter = tokenMap.entrySet().iterator(); iter.hasNext(); ) {
            final Map.Entry<String, TimeStampedToken<User>> next = iter.next();
            if (next.getValue().accessed + OBJECT_LIVE_TIME >= now)
                // the map is ordered by access time so there are no more to clean up.
                break;
            iter.remove();
        }
        // add a new entry
        tokenMap.put(tok.getUserId(), new TimeStampedToken<User>(tok, now));
    }

    public static synchronized User getToken(String userId) {
        final long now = System.currentTimeMillis();
        TimeStampedToken<User> user = tokenMap.get(userId);
        if (user == null)
            return null;

        user.accessed = now;
        return user.payload;
    }

    static class TimeStampedToken<E> {
        long accessed;
        final E payload;

        TimeStampedToken(E payload, long now) {
            this.payload = payload;
            accessed = now;
        }
    }
}