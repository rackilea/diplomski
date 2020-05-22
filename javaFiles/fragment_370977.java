@CollectionOfElements
@Enumerated(EnumType.STRING)
@JoinTable(
    name="BAR_TABLE",
    joinColumns=@JoinColumn(name="FOO_ID")
)
public Set<Bar> getBarSet() {
    return this.BarSet;
}