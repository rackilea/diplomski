@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = ComponentStyleMapperUtil.class)
public interface ComponentStyleMapper {

    @Mapping(target = "attribute", source = "hashMap", qualifiedBy = ComponentStyleMapperUtil.Attribute.class)
    @Mapping(target = "value", source = "hashMap", qualifiedBy = ComponentStyleMapperUtil.Value.class)
    ComponentStyleDTO hashMapToComponentStyleDTO(HashMap<String, Object> hashMap);
}