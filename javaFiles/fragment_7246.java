Map<String, Set<String>> followerMap = new HashMap<>();
    for (Entry<String, Set<String>> followingEntry : followingMap.entrySet()) {
        for (String follower : followingEntry.getValue()) {
            followerMap.computeIfAbsent(follower, s->new HashSet<>()).add(followingEntry.getKey());
        }
    }