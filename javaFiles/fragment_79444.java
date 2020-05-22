@Mapper
public interface OneMapper {

    @Mapping(target="id", source="one.id")
    @Mapping(target="qualified", qualifiedByName="checkQualifiedNamed")
    OneDto createOne (One one, @Context Integer projId, @Context String code);

    @Named("checkQualifiedNamed")
    default Boolean checkQualified (One one, @Context Integer projId, @Context String code) {
        if(one.getProjectId() == projId && one.getCode().equalsIgnoreCase(code)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;                   
    }
}