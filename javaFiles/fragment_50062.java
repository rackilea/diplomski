@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "A_ID")
private A a;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "B_ID")
private B b;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "C_ID")
private C c;