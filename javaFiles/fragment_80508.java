@Entity
@Table(name = "INCIDENCIAS")
@IdClass(IncidenciaKey.class)
public class Incidencia implements Serializable { 
    @Id
    @Column(name = "ID")
    private Integer id;
    @Id
    @Column(name = "ID_PROYECTO", nullable = false, insertable = false, updatable = false)
    private Long idProyecto;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull
    @Valid
    private Proyecto proyecto;
...
}