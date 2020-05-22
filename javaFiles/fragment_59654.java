@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalClient animalClient;

    @Override
    public ResponseEntity<String> createAnimals(AnimalsDTO animalsDTO) {
        for (BaseAnimalDTO animalDTO : animalsDTO.getAnimalDtos()) {
            animalClient.create(animalDTO);
        }
        ....
    }
}