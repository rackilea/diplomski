@Service
public class FileTypeService {
    private final List<String> fileTypes;

    @Autowired
    public FileTypeService(FileTypesConfig fileTypesConfig){
        this.fileTypes = fileTypesConfig.getFileTypes();
    }

    public List<String> getFileTypes(){
        return this.fileTypes;
    }

}