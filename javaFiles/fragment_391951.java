protected StringBuffer process(Collection<String> templateFields, MyObject object) {
    StringBuffer message = new StringBuffer(1000);
    for (String field : templateFields) {
      String[] fieldArray = field.split(Constants.SEPARATOR);
      String msg = FieldToMessageMapper.map(object, fieldArray[0], fieldArray[1])
        .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported field %s", field)));
      message.append(msg);
    }
    return message;
  }