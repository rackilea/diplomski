package example;
...
public class RallyResultUpdator implements TestCaseResultUpdator{

   @Override
   public String getToolName() {
    return "Rally";
   }

   /**
    * This method will be called by result updator after completion of each testcase/scenario.
    * @param params
    *            tescase/scenario meta-data including method parameters if any
    * @param result
    *            test case result
    * @param details
    *            run details
    * @return
    */

   @Override
   public boolean updateResult(Map<String, ? extends Object> metadata,
        TestCaseRunResult result, String details) {

    String tcid = metadata.get("RallyId");
    // Provide test management tool specific implemeneation/method calls

    return true;
   }
}