...
import org.springframework.data.elasticsearch.core.completion.Completion;
...

@Document(indexName = "test-completion-index", type = "annotated-completion-type", indexStoreType = "memory", shards = 1, replicas = 0, refreshInterval = "-1")
public class YoutEntity {

    @Id
    private String id;
    private String name;

    @CompletionField(payloads = true, maxInputLength = 100)
    private Completion suggest;

    ...
}