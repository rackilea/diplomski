public class ListThingToThingDTOConverter implements Converter<List<Thing>, List<ThingDTO>> {


@Override
public List<ThingDTO> convert(MappingContext<List<Thing>, List<ThingDTO>> context) {
    List<Thing> source = context.getSource();
    List<ThingDTO> output = new ArrayList<>();
    ...
    //Convert programmatically List<Thing> to List<ThingDTO>
    ...

    return output;
  }}