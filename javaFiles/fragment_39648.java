public class EntityToDTOPropertyMap extends PropertyMap<MyEntity, MyDTO> {

  Converter<Set<MyOtherEntity> , List<MyOtherDto>> toOtherDto = new Converter<Set<MyOtherEntity> , List<MyOtherDto>>() {
    public String convert(MappingContext<Set<MyOtherEntity> , List<MyOtherDto>> context) {
      Set<MyOtherEntity> source = context.getSource();
      List<MyOtherDto> destination = context.getDestination();
      //Convert it using the logic you want (by hand for example)

      return destination;
    }
  };

  @Override
  protected void configure() {
    using(toOtherDto).map(source.getOther()).setOther(null);
  }
}