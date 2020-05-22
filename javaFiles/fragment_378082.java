@Mapper
public interface MyMapper {

    @Mapping(source = "mySourceField", target = "myTargetField", qualifiedByName = "myTransformation")// or you can use a custom @Qualifier annotation with qualifiedBy
    TypeDest toSiteCatTag(TypeSrc obj);

    @Named("myTransformation")// or your custom @Qualifier annotation
    default Integer myCustomTransformation(String obj) {
        return Formatter.toSquare(Formatter.toInteger(obj));
    }
}