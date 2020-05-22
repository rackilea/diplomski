@Aspect
@Component
public class TutorRepositoryAspect {
    private Logger log = LoggerFactory.getLogger(TutorRepositoryAspect.class.getName());

    private AttachmentRepository attachmentRepository;

    private ApplicationConfiguration configuration;

    private S3Service s3Service;

    @Autowired
    public TutorRepositoryAspect(AttachmentRepository attachmentRepository,
                                 ApplicationConfiguration configuration,
                                 S3Service s3Service) {
        this.attachmentRepository = attachmentRepository;
        this.configuration        = configuration;
        this.s3Service            = s3Service;
    }

    @Pointcut(value = "execution(* com.example.tutor.backend.repository.attachment.AttachmentRepository.save(..)) && args(attachment)")
    private void repositorySave(Attachment attachment) {
    }

    @Before(value = "repositorySave(attachment)", argNames = "attachment")
    private Attachment beforeSave(Attachment attachment) {
        log.info("Received request to add attachment to tutor \"{}\".", attachment.getIdentifier());

        File file = attachment.getFile();

        // Validation

        String filePath = attachment.getAttachedTo().getIdentifier() + "-" + attachment.getName() + "-"
                          + attachment.getOriginalFileName();

        if (s3Service.isFilePresent(filePath)) {
            log.error("Could not upload file as there is a file already with the same name.");
            throw new IllegalArgumentException("File is already present.");
        }

        String s3Path = s3Service.uploadFile(file, filePath);

        attachment.setFilePath(s3Path);

        // This attachment is now being saved to database.
        return attachment;
    }
}