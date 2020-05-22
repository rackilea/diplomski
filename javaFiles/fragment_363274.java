import java.util.Collection;

import org.burningwave.core.assembler.ComponentContainer;
import org.burningwave.core.assembler.ComponentSupplier;
import org.burningwave.core.io.PathHelper;
import org.burningwave.tools.dependencies.Capturer.Result;
import org.burningwave.tools.dependencies.TwoPassCapturer;

public class DependenciesExtractor {    

    public static void main(String[] args) throws Exception {
        ComponentSupplier componentSupplier = ComponentContainer.getInstance();
        PathHelper pathHelper = componentSupplier.getPathHelper();
        Collection<String> paths = pathHelper.getPaths(PathHelper.MAIN_CLASS_PATHS, PathHelper.MAIN_CLASS_PATHS_EXTENSION);
        String jdk8Home = "C:/Program Files/Java/jdk1.8.0_172";
        paths.addAll(pathHelper.loadPaths("dependencies-capturer.additional-resources-path", "//" + jdk8Home + "/jre/lib//children:.*\\.jar;//" + jdk8Home + "/jre/lib/ext//children:.*\\.jar;"));
        Result result = TwoPassCapturer.getInstance().captureAndStore(
            "your.package.YourSpringBootApplicationClassWithMainMethod",
            paths,
            System.getProperty("user.home") + "/Desktop/dependencies",
            true,
            0L
        );
        result.waitForTaskEnding();
    }
}