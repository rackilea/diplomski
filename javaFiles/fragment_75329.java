return objects.stream()
              .filter(object -> object.getSomething() == Something.SomethingHighPriority)
              .findFirst()
              .orElseGet(() -> objects.stream()
                                      .filter(object -> object.getSomething() == Something.SomethingLowPriority)
                                      .findFirst()
                                      .orElse(null));