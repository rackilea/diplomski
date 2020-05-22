@Column(unique = true)
@ManyToOne(optional = false, fetch = FetchType.EAGER)
private ProductSerialMask mask;

@Column(unique = true)
@ManyToOne(optional = false, fetch = FetchType.EAGER)
private Group group;