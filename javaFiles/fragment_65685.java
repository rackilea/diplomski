@Mapper(componentModel = "spring", uses = { PersonService.class }) 
 public interface SchoolMapper extends EntityMapper<SchoolDTO, School>{ 

  @Mapping(source = "personId", target = "person") 
  School toEntity(SchoolDTO schoolDTO); 
 }