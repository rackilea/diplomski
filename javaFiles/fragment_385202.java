private ConcurrentMap<GroupCriteria, GroupData> collectionHolder = new MapMaker()
        .makeComputingMap(
           new Function<GroupCriteria, GroupData>() {
              @Override
              public GroupData apply(GroupCriteria key) {
                 //get from database and return
              }
        });