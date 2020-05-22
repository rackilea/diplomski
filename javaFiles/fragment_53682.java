CacheBuilder.newBuilder()
  .removalListener(new RemovalListener<Foo, Bar>() {
    public void onRemoval(RemovalNotification<Foo, Bar> notification) {
      if (notification.getCause() == RemovalCause.EXPIRED) {
        // we only care about these removals
      }
    }
  })
  .build();