@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(referencedColumnName = "id",name = "id_profesor", insertable=false, updatable=false)
private Profesor profesor;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(referencedColumnName = "id",name = "id_asignatura", insertable=false, updatable=false)
private Asignatura asignatura;