@Mapper(componentModel = "spring")
public interface ScreenDocumentMapper extends BaseMapper<Entity, ScreenDocumentDto> {

    @Mapping(source = "entities", target = "someLinks")
    ScreenDocumentDto toDto(Entity entity, List<Entity> entities);

    @Mapping(source = "entityMetadata.someDate", target = "someDate")
    SomeLinkDto toLinkDto(Entity entity);
}