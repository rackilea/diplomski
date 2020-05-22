import com.google.common.base.Joiner;
import org.apache.commons.lang.SystemUtils;
import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.ivy.util.Checks.checkNotNull;

public class GroovyRunner {
    private final static Logger logger = LoggerHelper.getLogger();

    public static void runGroovyScript(Path scriptPath, String... args) {
        try {
            List<String> argsList = newArrayList();
            String groovyPath = System.getenv("PLAY_GROOVY_PATH");

            if (SystemUtils.IS_OS_WINDOWS) {
                // Window, no easy default for PLAY_GROOVY_PATH
                checkNotNull(groovyPath, "Missing Env Var 'PLAY_GROOVY_PATH'");

                argsList.add("cmd");
                argsList.add("/c");
                argsList.add(groovyPath);
            } else {
                if (groovyPath == null) {
                    // Provide a reasonable default for linux
                    groovyPath = "/usr/bin/groovy";
                }
                argsList.add(groovyPath);
            }

            argsList.add(scriptPath.toAbsolutePath().toString());
            Collections.addAll(argsList, args);

            String join = Collections3.join(argsList, " ");

            ExecCommand process = new ExecCommand(join);

            // Note - out input is the process' output
            String output = process.getOutput();
            String error = process.getError();

            logger.info("Groovy output for " + Arrays.toString(args) + "\r\n" + output);
            logger.info("Groovy error for " + Arrays.toString(args) + "\r\n" + error);


            if (process.getReturnValue() != 0) {
                throw new RuntimeException("Groovy process returned " + process.getReturnValue());
            }
        } catch (Throwable e) {
            throw new RuntimeException("Failure running groovy script: " + scriptPath + " " + Joiner.on(" ").join(args), e);
        }
    }
}