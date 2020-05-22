@Service
public class AnimalService {
  @Autowired
  private AnimalEntityRepository animalRepo;


  public Page<AnimalEntity> findAnimal(String name) {

    Page<AnimalEntity> animals = animalRepo.findByName(name, new PageRequest(1,20));

    return animals;
  }
}