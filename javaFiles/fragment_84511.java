public final class Item implements Serializable {
  @Column(name = "col1")
  private String col1;

  @Column(name = "col2")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String col2;

  @Column(name = "col3")
  private String col3;

  Item() { }

  @PrePersist
  public void updateCol3(){
      col3 = col1 + col2;
  }
}