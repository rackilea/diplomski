/**
 * 
 */
private static final long serialVersionUID = -3902534586060936635L;

@EmbeddedId
private CotePK cotePK;

@ManyToOne
@MapsId("evaluationId")
@JoinColumn(name="EVALUATION", referencedColumnName = "NUDOSS")
private Evaluation evaluation;

@ManyToOne
@MapsId("critereId")
@JoinColumn(name="CRITERE", referencedColumnName = "CODE")
private Critere critere;

@ManyToOne
@MapsId("seuilId")
@JoinColumn(name="SEUIL", referencedColumnName = "CODE")
private Seuil seuil;