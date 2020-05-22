@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    CarEntity carDtoToCarEntity(CarDto carDto); 
    PersonEntity personDtoToPersonEntity(PersonDto personDto);

}