class PersonDtoWithFax extends PersonDto {
    @Expose String fax;
    PersonDtoWithFax(final Person person) {
        super(person);
        fax = person.fax;
    }
}