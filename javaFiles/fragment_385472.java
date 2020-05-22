@Mapper
public interface ConclusionMapper {

    @Mappings({
           @Mapping(target = "cTypes", source = "cTypeEntities")
    })
    Conclusion toConclusion(ConclusionEntity entity);

    List<Conclusion> toConclusionList(List<ConclusionEntity> entities);

    @InheritInverseConfiguration
    ConclusionEntity fromConclusion(Conclusion conclusion);

    List<ConclusionEntity> fromConclusionList(List<Conclusion> conclusions);

    @Mappings({
            @Mapping(target = "vType", ignore = true)
    })
    ConclusionTaxType toCType(CTypeEntity cTypeEntity);

    List<CType> toCTypes(List<CTypeEntity> cTypeEntities);

    @Mappings({
            @Mapping(target = "vTypeId", source = "vType.id")
    })
    CTypeEntity fromCType(CType cType);

    List<CTypeEntity> fromCTypeList(List<CType> cTypes);
}