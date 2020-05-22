@Mapper
public interface MyMapper{

   // will map all other fields that you specify
   @Mapping( target = "city_names", ignore = true )
   @Mapping( target = "technologies", ignore = true )
   Target map(Source1 s1, Soruce2 s2);

   default map(Source1 s1, Soruce2 s2, @MappingTarget Target t) {
      // do whatever you like with city_names and technologies
   }


}