@Service
public class RistoreServiceBean implements RistoreService {
    public InputStream findByTRF(String trf) throws IOException {
        String filePath = "/Users/djiao/Box Sync/Work/Projects/RIStore/foundation/foundation_new/" + trf + ".xml";
        File file = new File(filePath);
        return new FileInputStream(file);
    }
}