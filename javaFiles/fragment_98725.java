List<ApplicationConfiguration> ApplicationConfigurations = 
    Arrays.stream(objectsArray)
          .map(obj -> (Map.Entry<Class, Object>) obj)
          .map(Map.Entry::getValue)
          .filter(item -> item instanceof ApplicationConfiguration)
          .map(item -> (ApplicationConfiguration)item)
          .collect(Collectors.toList());