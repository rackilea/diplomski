@RepositoryRestController
@RequestMapping("/upload")
public class MediaEndpoint {

    @Autowired
    private MediumRepository mediumRepository;

    @RequestMapping(method = POST)
    public ResponseEntity<PersistentEntityResource> uploadMedium(
            @RequestPart MultipartFile data,
            PersistentEntityResourceAssembler persistentEntityResourceAssembler) {

        Medium medium = new Medium();
        // setup of the medium instance
        Medium savedMedium = mediumRepository.save(medium);
        return ResponseEntity.ok(persistentEntityResourceAssembler.toResource(savedMedium));
    }
}