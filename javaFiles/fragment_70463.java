User[] maxUser = new User[1];
    for (int i = 0; i < users.segments(); i++) {
        try (MapSegmentContext<IntValue, User, ?> c = map.segmentContext(i)) {
            c.forEachSegmentEntry((MapEntry<IntValue, User> e) -> {
              User user = e.value().get();
              if (maxUser[0] == null || user.compareTo(maxUser[0]) > 0) {
                // Note that you cannot just assign `maxUser[0] = user`:
                // this object will be reused by the SegmentContext later
                // in the iteration, and it's contents will be rewritten.
                // Check out the doc for Data.get().
                if (maxUser[0] == null) {
                  maxUser[0] = Values.newHeapInstance(User.class);
                }
                User newMaxUser = e.value().getUsing(maxUser[0]);
                // assert the object is indeed reused
                assert newMaxUser == maxUser[0];
              }
            });
        }
    }