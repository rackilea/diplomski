@Fetch(FetchMode.SELECT)
@CollectionType(type = "ca.tecsar.core.sql.LazySetType")
@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
@Filter(
        name="punchesBetweenDates",
        condition="{p}.adjustedIn >= :start and {p}.adjustedIn < :end",
        aliases = {
                @SqlFragmentAlias(alias = "p", table = "PUNCH")
        }
)
private Set<Punch> punches;