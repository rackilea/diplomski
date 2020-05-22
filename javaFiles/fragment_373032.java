@Service
public class RunnerApp implements CommandLineRunner {

    @Autowired
    private ArchiveFactory archiveFactory;

    @Override
    public void run(String... strings) throws Exception {

        Report report = new Report("ZIP");
        Archive archive = archiveFactory.get(report.getType());
        System.out.println(archive.makeArchive());
   }
}