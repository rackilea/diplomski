@CollectionOfElements
@Enumerated(EnumType.STRING)
@JoinTable(
    name="SELECTED_DAYS_OF_THE_WEEK",
    joinColumns=@JoinColumn(name="<OWNING_ENTITY_ID_GOES_HERE>")
)
public Set<DAYS_OF_THE_WEEK> getSelectedDays() {
    return this.selectedDays;
}