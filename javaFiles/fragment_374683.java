@Test
public void should_map_multiple_fields_into_one() {

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    modelMapper.createTypeMap(Person.class, PersonDto.class)
            .addMappings(
                    new PropertyMap<Person, PersonDto>() {
                        @Override
                        protected void configure() {
                            // define a converter that takes the whole "person"
                            using(ctx -> generateFullname(
                                    ((Person) ctx.getSource()).getFirstname(),
                                    ((Person) ctx.getSource()).getLastname())
                            )
                            // Map the compliete source here
                            .map(source, destination.getFullname());
                        }
                    });

    // test that all fields are mapped
    modelMapper.validate();

    // test that the age is calculated
    Person person = new Person();
    person.setFirstname("Marilyn");
    person.setLastname("Monroe");
    PersonDto personDto = modelMapper.map(person, PersonDto.class);
    assertEquals(personDto.fullname, "Marilyn Monroe");
}

// This method should be used for mapping. In real, this could be a service call
private String generateFullname(String firstname, String lastname) {
    return firstname + " " + lastname;
}