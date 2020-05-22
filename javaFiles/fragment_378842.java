public CaseComent {
  // ...

  @JsonTypeInfo(use=JsonTypeInfo.Id.NONE, include=JsonTypeInfo.As.EXTERNAL_PROPERTY)
  public Date getCreatedDate() {
    // ...
  }
}