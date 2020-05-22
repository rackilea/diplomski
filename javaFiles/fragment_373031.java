@Component
public class ArchiveFactory {
    @Autowired
    private Map<String, Archive> archives;

    public Archive getArhive(String archiveType) {
        return archives.get(archiveType);
    }
}