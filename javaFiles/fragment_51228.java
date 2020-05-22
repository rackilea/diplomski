public Foo {
  @OneToMany
  private List<Bar> bars;

  @Column
  private int barSize;

  @PrePersist
  @PreUpdate
  public void updateBarSize() {
    this.barSize = (bars==null ? 0 : bar.size());
  }
}