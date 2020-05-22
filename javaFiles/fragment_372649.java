@OneToOne
@NotNull
@JoinColumns({
    @JoinColumn(name="NAME", referencedColumnName="NAME"),
    @JoinColumn(name="USERNAME", referencedColumnName="USERNAME")
})
private CashFlowCategory category;