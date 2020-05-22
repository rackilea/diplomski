@Mapper(componentModel = "spring")
public interface MapStructAdapter {

    @Mapping(source = "some", target = "some")
    @Mapping(source = "entityShortName", target = "legalEntities")
    Representative convert(Message message);

    default List<LegalEntity> toLegalEntities(String entityShortName) {
        LegalEntity legalEntity = new LegalEntity();
        legalEntity.setShortName(entityShortName);
        return Collections.singletonList(legalEntity);
    }
}