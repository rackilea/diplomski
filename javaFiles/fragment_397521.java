static class DataSyncWriteConverter implements Converter<DataSync, String> {

  public String convert(DataSync source) {

    try {
      return new ObjectMapper().writeValueAsString(source);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}