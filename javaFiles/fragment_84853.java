@OneToMany(targetEntity = Quadrat.class, cascade = CascadeType.ALL)
//@MapKeyJoinColumn(name="indice" , table = "telai_quadrati")
@JoinTable(
        name = "telai_quadrati", 
        joinColumns = {@JoinColumn(name = "telaio_id", table = "telai")}, 
        inverseJoinColumns = {@JoinColumn(name = "quadrato_id", table = "quadrati")})
@OrderColumn(name = "indice")
private List<Quadrat> quadratList;