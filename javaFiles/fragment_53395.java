@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(name = "event2work2instrumentation", joinColumns = {
        @JoinColumn(name = "event")},
        inverseJoinColumns = {@JoinColumn(name = "instrumentation")})
@MapKeyJoinColumn(name = "work")
private Map<WorkMapper, InstrumentationMapper> _eventToWorkAndInstrumentationMappers = new HashMap<>();