@Mapper(componentModel = "spring")
public interface ScreenDocumentMapper extends BaseMapper<Entity, ScreenDocumentDto> {

    @Mapping(source = "links", target = "someLinks")
    ScreenDocumentDto toDto(Entity entity);

    @Mapping(source = "entityMetadata.someDate", target = "someDate")
    SomeLinkDto toLinkDto(Entity entity);
}