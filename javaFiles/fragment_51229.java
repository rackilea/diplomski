public Foo {
  @OneToMany
  private List<Bar> bars;

  @Column
  private int barSize;

  public List<Bar> getBars() {
    return Collections.unmodifiableList(bars);
  }

  public synchronized void addBar(Bar bar) {
    this.bars.add(bar);
    this.barSize = bars.size();
  }
}