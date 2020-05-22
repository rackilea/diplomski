import org.slf4j.Logger
import org.slf4j.LoggerFactory

public void AssertValuesF(float Expected, float Actual, String PassMessage, String FailureMessage) {
    final Logger log = LoggerFactory.getLogger(getClass());

    if (Expected == Actual) {
        log.info("****Assertion Successful****");
        log.info("Actual: " + Actual + " Expected: " + Expected + "\n");
        log.info(PassMessage);

    } else {
        vars.put("AssertionFailure", "true");
        AssertionResult.setFailure(true);
        vars.put("FailureMsg", vars.get("FailureMsg") + "\n****ASSERTION FAILURE****** \n" + FailureMessage + " ||  EXPECTED: " + Expected + " || ACTUAL: " + Actual + "\n");

        log.info("****ASSERTION FAILURE******");
        // AssertionResult.setFailureMessage("****Assertion Failure****** "+FailureMessage + " Expected: "+ Expected + " Actual: "+Actual+"\n");
        log.info(FailureMessage);
        log.info("Actual: " + Actual + "Expected: " + Expected);
    }
}