public interface AMapper {
    AMapperINSTANCE = Mappers.getMapper(AMapper.class);

    B AtoB(A entity);

}