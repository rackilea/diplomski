@Component
public class GenerateResponse{
@Autowired
PetApiService petApiService;

    public ResponseEntity<ModelApiResponse> uploadFile(Long petId, String additionalMetadata, MultipartFile file){
    return petApiService.uploadFile(file);
    }
}