mapperFactory.classMap(Person.class, PersonDTO.class)
.field("age","personAge")
.byDefault()
.customize(
   new CustomMapper<Person, PersonDTO> {
      public void mapAtoB(Person a, PersonDTO b, MappingContext context) {
         b.setName(a.getFirstName()+ " "+a.getLastName());
      } 
   })
.register();