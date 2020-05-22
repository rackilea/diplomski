import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "config")
@Component
public class SampleConfigProperties {

    @Autowired
    private ConversionService conversionService;
    private List<String> entry;

    private Map<String, String> entriesMap;


    public List<String> getEntry() {
        return entry;
    }

    public void setEntry(List<String> entry) {
        this.entry = entry;
    }

    public Map<String, String> getEntriesMap() {
        return entriesMap;
    }

    public void setEntriesMap(Map<String, String> entriesMap) {
        this.entriesMap = entriesMap;
    }

    @PostConstruct
    public void postConstruct() {
        Map<String, String> entriesMap = new HashMap<>();
        for (String anEntry: entry) {
            List<String> l = conversionService.convert(anEntry, List.class);
            entriesMap.put(l.get(0), l.get(1));
        }
        this.entriesMap = entriesMap;
    }

}