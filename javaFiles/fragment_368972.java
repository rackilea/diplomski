@Mapper
public interface MyMapper {

    default CarEntity entity2Dto(CarDto dto) {
        if (dto == null) {
            return null;
        } else if (Objects.equals(dto.getDiscriminator(), "suv")) {
            return fromSuv(dto));
        } //You need to add the rest
   } 

    SuvEntity fromSuv(CarDto dto);
}