@JsonbTransient
@ManyToOne
@JoinColumn(name = "idTechnologyGroup", referencedColumnName = "idTechnologyGroup", nullable = false)
public Mestechnologygroup getMestechnologygroupByIdTechnologyGroup() {
    return mestechnologygroupByIdTechnologyGroup;
}