class PersonDto {
    @Expose String name;
    @Expose String phone;
    PersonDto(final Person person) {
        name = person.name;
        phone = person.phone;
    }
}