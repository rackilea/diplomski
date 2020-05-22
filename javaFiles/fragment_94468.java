@BasePathAwareController
@ExposesResourceFor(Tutor.class)
public class TutorRepositoryController {
    private AttachmentAssembler attachmentAssembler;

    private AttachmentRepository attachmentRepository;

    private TutorRepository tutorRepository;

    private RepositoryEntityLinks entityLinks;

    @Autowired
    public TutorRepositoryController(AttachmentAssembler attachmentAssembler,
                                     AttachmentRepository attachmentRepository,
                                     TutorRepository tutorRepository,
                                     RepositoryEntityLinks entityLinks) {
        this.attachmentAssembler  = attachmentAssembler;
        this.attachmentRepository = attachmentRepository;
        this.tutorRepository      = tutorRepository;
        this.entityLinks          = entityLinks;
    }

    @PostMapping(value = "/tutors/{id}/attachments/{name}")
    public ResponseEntity<EntityModel<Attachment>> saveAttachment(@RequestParam("data") MultipartFile file,
                                                                  @PathVariable long id,
                                                                  @PathVariable String name) {
        Tutor thisTutor = tutorRepository.findById(id);
        File tempFile;
        try {
            tempFile = File.createTempFile(FilenameUtils.getBaseName(file.getOriginalFilename()),
                                           FilenameUtils.getExtension(file.getOriginalFilename()));

            StreamUtils.copy(file.getResource().getInputStream(), new FileOutputStream(tempFile));
        } catch (IOException e) {
            throw new RuntimeException("Could not create temporary file of uploaded file.");
        }

        Attachment saved =
                    attachmentRepository.save(new Attachment(name, thisTutor, tempFile, file.getOriginalFilename()));

        return ResponseEntity.created(entityLinks.linkForItemResource(Attachment.class, saved.getIdentifier())
                                                  .toUri()).body(attachmentAssembler.toModel(saved));
    }
}