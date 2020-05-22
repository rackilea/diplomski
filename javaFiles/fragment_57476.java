@OneToOne(fetch=FetchType.EAGER)
  @JoinColumns({
      @JoinColumn(name = "dataId", insertable = false, updatable = false, referencedColumnName = "dataId"),
      @JoinColumn(name = "occurrenceTime", insertable = false, updatable = false, referencedColumnName = "occurrenceTime")
  })
  private ForwardPower forwardPower;