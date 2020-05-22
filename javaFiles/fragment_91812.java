//ResponsableEntity  class
@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "id")
private Account account;

//Account class
@OneToOne(mappedBy = "account", cascade = CascadeType.ALL,
fetch = FetchType.LAZY, optional = false)
private ResponsableEntity  responsableEntity;