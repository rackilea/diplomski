@Mapper
public interface OneMapper {

    @Mapping(target="id", source="one.id")
    @Mapping(target="qualified", qualifiedByName="checkQualifiedNamed")
    OneDto createOne (One one, @Context Filter filter);

    @Named("checkQualifiedNamed")
    default Boolean checkQualified (One one, @Context Filter filter) {
        if(one.getProjectId() == filter.getProjId() && one.getVal() == filter.getVal() && one.getCode().equalsIgnoreCase(filter.getCode())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;                   
    }
}