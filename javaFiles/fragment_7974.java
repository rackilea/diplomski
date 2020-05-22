@Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "childId", target = "child.id")
})
public abstract Entity objectDtoToEntity(ObjectDTO objectDTO);


@AfterMapping
public Entity doAfterMapping(@MappingTarget Entity entity) {
    if (entity != null && entity.getChild().getId() == null) {
        entity.setChild(null);
    }
    return entity;
}