public class DTOToEntityPropertyMap extends PropertyMap<MyOtherEntity, MyOtherDTO> {
  @Override
  protected void configure() {
    map().setPropertyOfOther(source.getPropertyOfOther());
    //and so on...
  }
}

modelMapper.addMappings(new DTOToEntityPropertyMap());