@Controller
public class PetApiController implements PetApi {

@Autowired
GenerateResponse generateResponse;
...
  public ResponseEntity<ModelApiResponse> uploadFile(@ApiParam(value = "ID of pet to update",required=true ) @PathVariable("petId") Long petId,
    @ApiParam(value = "Additional data to pass to server") @RequestPart(value="additionalMetadata", required=false)  String additionalMetadata,
      @ApiParam(value = "file detail") @RequestPart("file") MultipartFile file) {
      return generateResponse.uploadFile(petId, additionalMetadata, file);
  }
...
}