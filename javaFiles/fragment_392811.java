@ManyToOne
@JoinColumn(name = "business_id")
private Business business;

@ManyToOne
@JoinColumn(name = "process_id")
private Process process;