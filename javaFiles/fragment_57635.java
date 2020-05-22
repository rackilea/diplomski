@Inject CatRepository catRepository;

 @Transactional
 void changeColorToCat(String color, String catName) {
    Cat timmy = catRepository.findByName("Timmy");
    timmy.color = "red";
 }