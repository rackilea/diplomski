((List<Object>) definitions).stream()
      .map(Definition.class::cast)
      .map(definition -> {
          WonderfulDefinition wd = new WonderfulDefinition();
          wd.name(definition.getName());
          //etc
          return wd;
      }).collect(Collectors.toList());