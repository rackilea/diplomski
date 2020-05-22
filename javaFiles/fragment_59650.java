@Service
public class CatClient implements BaseAnimalClient {

    private static final String CODE_WS_CREATE_CAT = "createCat";

    @Override
    public ResponseEntity<String> create(BaseAnimalDTO dto) {
        return null;
    }
}