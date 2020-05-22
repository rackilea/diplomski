Stream<AppStory> appStr1 =StreamSupport.stream(splititerato1, false)
                                       .map(this::vertexToStory1);
Stream<AppStory> appStr2 =StreamSupport.stream(splititerato2, false)
                                       .map(this::vertexToStory2);
Stream<AppStory> appStr3 =StreamSupport.stream(splititerato3, false)
                                       .map(this::vertexToStory3);

List<AppStory> stories = Stream.concat(Stream.concat(appStr1, appStr2), appStr3)
                               .distinct().collect(Collectors.toList());
// assuming AppStory::getLastUpdateTime is of type `long`
stories.sort(Comparator.comparingLong(AppStory::getLastUpdateTime));