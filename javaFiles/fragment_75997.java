@Embeddable
public class SolicitudGUCDetalleId implements Serializable {

  @Column(name = "IDPEDIDO", insertable = false, updatable = false)
  @Size(max = 36)
  private String idPedido;

  @Column(name = "IDLINEA", precision = 10, scale = 0, insertable = false, updatable = false)
  private long idLinea;

  ...
}

@Entity
@Table(name = "TRIISOLIDGUCDET")
public class SolicitudGUCDetalle implements Serializable {

  @EmbeddedId
  private SolicitudGUCDetalleId id;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "solicitudGUCDetalle")
  private SolicitudGUCEnvio solicitudGUCEnvio;

  ...
}

@Embeddable
public class SolicitudGUCEnvioId implements Serializable {

  @Column(name = "IDPEDIDO", insertable = false, updatable = false)
  @Size(max = 36)
  private String idPedido;

  @Column(name = "IDLINEA", insertable = false, updatable = false)
  private long idLinea;

  ...
}

@Entity
@Table(name = "TRIISOLIDGUCENV")
public class SolicitudGUCEnvio implements Serializable {


  @EmbeddedId
  private SolicitudGUCEnvioId id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumns({@JoinColumn(name = "IDLINEA", referencedColumnName = "IDLINEA"),
      @JoinColumn(name = "IDPEDIDO", referencedColumnName = "IDPEDIDO")})
  @MapsId
  private SolicitudGUCDetalle solicitudGUCDetalle;

  ...
}