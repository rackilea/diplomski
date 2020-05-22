class StringToGender implements Converter<String, Gender> {
  @Autowired
  private GenderRepository repository;

  public Gender convert(String name) {
    return repository.getGenderByName(name);
  }
}