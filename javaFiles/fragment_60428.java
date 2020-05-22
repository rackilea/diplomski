when(yourComponent.acceptString(not(argThat(new MatchesPattern(yourPattern)))
    .thenThrow(new IllegalArgumentException());

// or with the static factory method:
when(yourComponent.acceptString(not(argThat(matchesPattern(yourPattern)))
    .thenThrow(new IllegalArgumentException());