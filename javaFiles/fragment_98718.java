List<Activity> output =
    activities.stream()
              .collect(collectingAndThen(
                  groupingBy(
                    Activity::getName,
                    mapping(Activity::getActivityId, toList())
                  ),
                  m -> m.entrySet().stream()
                                   .map(e -> new Activity(null, e.getKey(), e.getValue()))
                                   .collect(toList())
              ));