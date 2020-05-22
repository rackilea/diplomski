@SpringBootApplication(exclude = JpaRepositoriesAutoConfiguration.class)
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(DBReportRepository DBReportRepository, ClearingFileParser clearingFileParser)
    {
        return args -> {

            clearingFileParser.parse("clearing.alert");
            ClearingFileModel clearingFileModel = clearingFileParser.getClearingFileData();
...