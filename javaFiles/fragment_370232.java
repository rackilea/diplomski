@OneToMany
@JoinTable(
        name="compuestoDe",
        joinColumns = @JoinColumn( name="codProductoE"),
        inverseJoinColumns = @JoinColumn( name="codProductoSM")
        )
private List<Producto>componentes;