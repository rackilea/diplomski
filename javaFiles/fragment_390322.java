@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TDM_TAC")
private TiposDominioMantenimiento tdmTac;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TDN_ECO") 
private TiposDominioMantenimiento tdnEco;