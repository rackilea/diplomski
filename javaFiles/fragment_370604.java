@Path("/upload")
@Produces(MediaType.APPLICATION_JSON)
public class UploadResource {

  private final FileDao fileDao;
  private final String uploadPath;

  @Inject
  public UploadResource(FileDao fileDao, @Named("{someName}") String uploadPath) {
    this.fileDao = fileDao;
    this.uploadPath = uploadPath;
  }

}