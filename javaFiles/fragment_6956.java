@Id 
@GeneratedValue
@Column(name = "IDTESTOBJEKT", unique = true, nullable = false)
public Integer getIdtestobjekt() {
    return this.idtestobjekt;
}