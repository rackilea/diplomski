@Service
public class AnimalClient implements BaseAnimalClient {

    @Autowired
    private CatClient catClient;

    @Autowired
    private DogClient dogClient;

    @Autowired
    private HorseClient horseClient;

    @Override
    public ResponseEntity<String> create(BaseAnimalDTO dto) {
        BaseAnimalClient client;
        if (dto instanceof CatDTO) {
            client = catClient;
        } else if (dto instanceof DogDTO) {
            client = dogClient;
        } else {
            client = horseClient;
        }
        return client.create(dto);
    }
}