public List<AssignedSelect> assignSelectFrom(SelectDto selectDto) {
    Objects.requireNonNull(selectionDto, "selectionDto can not be NULL");

    List<AssignedSelect> assignedSelects= new ArrayList<>();
    for(SelectDtoProcessor processor: processors) {
        processor.process(selectDto, assignedSelects::addAll);
    }
    return assignedSelects;
}