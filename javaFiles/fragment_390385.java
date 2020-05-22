@Valid
 @NotNull
 @JsonProperty
 private DataSourceFactory database = new DataSourceFactory();

 public DataSourceFactory getDataSourceFactory() {
    return database;
 }