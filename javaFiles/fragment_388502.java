class AssignedOpDtoMapper implements SelectDtoProcessor {
    @Override
    public void process(SelectDto dto, 
                        Consumer<? super Collection<? extends AssignedSelect>> action){
        List<OptionCodeDto> ops = dto.getOps();
        consumer.accept(mapCriterias(ops));
}