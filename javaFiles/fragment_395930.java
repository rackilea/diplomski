@ManyToOne(fetch=FetchType.LAZY)
@JoinColumns({
    @JoinColumn(name="id_municipio", referencedColumnName="id_municipio"),
    @JoinColumn(name="id_depto", referencedColumnName="id_depto")
})
private Municipio municipio;