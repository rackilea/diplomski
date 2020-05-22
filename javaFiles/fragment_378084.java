@Mapper(uses = { Formatter.class })
public interface MyMapper {

    @Mapping(source = "mySourceField", target = "myTargetField", qualifiedBy = SquaredString.class)
    TypeDest toSiteCatTag(TypeSrc obj);
}