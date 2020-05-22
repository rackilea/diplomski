@Id 
@Column(name = "ORG_ID")
private Integer orgId;
...
@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
@JoinColumn(name = "ORG_ID")
private GbCapacityEntity gbCapacityEntity;