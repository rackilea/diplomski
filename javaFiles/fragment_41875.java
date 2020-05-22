@Mapper
public interface FruitsMapper {
    FruitsMapper INSTANCE = Mappers.getMapper(FruitsMapper.class);

    @BeanMapping(resultType = AppleDto.class)
    Fruit map(AppleEntity entity);

    List<Fruit> entityToFruits(List<AppleEntity> entity);
}