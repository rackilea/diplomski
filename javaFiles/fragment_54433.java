@Mapper(componentModel = "spring")
@Component
public interface DtoMapper {

    @Mapping(target = "type", constant = "bike")
    BikeDto toBikeDto(Bike entity);

    Bike toBikeEntity(BikeDto dto);
}