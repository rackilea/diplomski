protected String process(Collection<String> templateFields, MyObject object) {
    return templateFields.stream()
      .map(field -> field.split(Constants.SEPARATOR))
      .map(fieldArray -> FieldToMessageMapper.map(object, fieldArray[0], fieldArray[1])
        .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported field %s", Arrays.toString(fieldArray)))))
      .collect(Collectors.joining());
  }