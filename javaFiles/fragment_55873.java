@ElementCollection(fetch = FetchType.EAGER)
@CollectionTable(name = "T_B",
        schema = "owner",
        joinColumns = @JoinColumn(name = "B_A_ID",
                referencedColumnName = "A_ID",
                nullable = false))
@MapKeyColumn(name = "B_RUN_ID")
@Column(name = "B_STATUS")
@Enumerated(javax.persistence.EnumType.STRING)
private Map<Long, Status> trackings;