@Service
@ComponentScan(basePackages = {"com.package.repgen.*"})
@PropertySource("classpath:application.properties")
public class ClearingFileParser implements FileParser {

    private int fileParsedYearValue;
    ...

    private static final Logger log = LoggerFactory.getLogger(ClearingFileParser.class);

    @Autowired
    private ClearingAlertFileProperties clearingAlertFileProperties;

    @Override
    public void parse (String file) throws IOException {
        String clearingFileFolder = clearingAlertFileProperties.getFolder();
        String contents = new String(Files.readAllBytes(Paths.get(clearingFileFolder + file)));
        ...
    }

    public ClearingFileModel getClearingFileData() {
        ClearingFileModel clearingFileModel = new ClearingFileModel();
        clearingFileModel.setYear(fileParsedYearValue);
        ...

        return clearingFileModel;
    }
}