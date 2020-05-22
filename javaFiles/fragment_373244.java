@Mapper
public interface ToDTOMapper {
    ToDTOMapper MAPPER = Mappers.getMapper(ToDTOMapper.class);

    BaseSubDTO toDTOFromBaseClass(BaseClass baseClass);

    BaseSubDTO toDTOFromSubClass(SubClass baseClass);

    default BaseSubDTO map(BaseClass baseClass) {
        if(baseClass instanceof SubClass) {
            return toDTOFromSubClass((SubClass)baseClass);
        } 
        return toDTOFromBaseClass(baseClass);
    }
}