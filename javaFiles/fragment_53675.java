import com.atlassian.bamboo.process.ProcessService;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

@Scanned
public class CheckTask implements TaskType {

    @ComponentImport
    private final ProcessService processService;

    public CheckTask(@NotNull final ProcessService processService) {
        this.processService = processService;
    }