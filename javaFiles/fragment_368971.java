@Mapper
public interface MyMapper {

    default CarEntity entity2Dto(CarDto dto) {
        if (dto == null) {
            return null;
        } else if (dto instance of SuvDto) {
            return fromSuv((SuvDto) dto));
        } //You need to add the rest
    }

    SuvEntity fromSuv(SuvDto dto);
}