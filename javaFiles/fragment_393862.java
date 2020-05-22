abstract class EntityMapper<DTO extends Dto<DTOA>, DTOA, E> {

    E toEntity(DTO dto) {
        E entity = toEntity(dto.getAttributes());
        if (entity != null) {
            entity.setId(dto.getId());
        }
        return entity;
    }

    @Mapping(target = "id", ignore = true)    
    abstract E toEntity(DTOA dtoAttributes);

    abstract DTO toDto(E entity);

    abstract DTOA toDtoAttributes(E entity);

    abstract List<E> toEntityList(List<DTO> dtos);

    abstract List<DTO> toDtoList(List<E> entities);

    @AfterMapping
    protected void afterMapping(@MappingTarget DTO dto, E entity) {
        DTOA dtoAttributes = this.toDtoAttributes(entity);
        dto.setAttributes(dtoAttributes);
    }
}