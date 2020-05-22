@Bean
  public DogHouse dogHouse() {
    Dog d = dog();
    ...
    return dogHouse;
  }