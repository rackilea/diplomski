import java.io.File;
import java.io.FileOutputStream;

import org.apache.tools.ant.taskdefs.optional.junit.XMLJUnitResultFormatter;
import org.junit.internal.TextListener;
import org.junit.runner.Computer;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;

import com.myproject.suites.MainTestSuite;
import com.myproject.util.JUnitResultFormatterAsRunListener;

public class TestRunner {

  public static void main(String[] args) {

    if (args.length <= 0) {
      throw new RuntimeException("Reports dir must be on arg[0]");
    }

    final File reportDir = new File(args[0]);

    JUnitCore junit = new JUnitCore();
    junit.addListener(new TextListener(System.out));
    if (reportDir != null) {
      reportDir.mkdirs();
      junit.addListener(new JUnitResultFormatterAsRunListener(new XMLJUnitResultFormatter()) {
        @Override
        public void testStarted(Description description) throws Exception {
          formatter.setOutput(new FileOutputStream(new File(reportDir, "TEST-" + description.getDisplayName()
            + ".xml")));
          super.testStarted(description);
        }
      });
    }
    junit.run(new Computer(), MainTestSuite.class).getFailureCount();

  }
}