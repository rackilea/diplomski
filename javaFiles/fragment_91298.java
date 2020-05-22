stream.flatMap(t -> {
          Type1 value1 = func1(t);
          Type2 value2 = func2(t);
          return value1!=null && value2!=null? Stream.of(Map.entry(value1, value2)): null;
      })
      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));