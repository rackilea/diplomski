List<MatchEventMobileApp> matchEventMobileApp = matchEventService
    .findAllByMatch(SOME_MATCH)
        .stream()
        .sorted(Comparator.comparing(MatchEvent::getDateReceived))
        .map(de -> new MatchEventMobileApp(de)) // or MatchEventMobileApp::new
        .collect(Collectors.toList()); // better collect to a new list instead of
                                       // adding to an existing one within forEach