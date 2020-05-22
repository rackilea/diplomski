@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalClient animalClient;

    @Override
    public ResponseEntity<String> createAnimals(AnimalsDTO animalsDTO) {
        animalClient.create(animalsDTO.getCat());
        animalClient.create(animalsDTO.getDog());
        animalClient.create(animalsDTO.getHorse());
        .... 
    }
}