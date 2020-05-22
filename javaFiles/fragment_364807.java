@Aspect
 public class StepsInterceptor {


     @After("call(public * cucumber.runtime.StepDefinitionMatch.runStep(..)) && within(cucumber.runtime.Runtime)")
     public void beforeRunningStep(JoinPoint thisJoinPoint) throws Exception {

         try {
             StepDefinitionMatch stepDefinitionMatch = (StepDefinitionMatch) thisJoinPoint.getTarget();
             Step step = (Step) retrievePrivateField(stepDefinitionMatch, "step");
             String stepName = step.getKeyword().trim();

             if ("Given".equals(stepName) || "When".equals(stepName)) {
                 Object theRealStepDef = extractJavaStepDefinition(stepDefinitionMatch);
                // take screen shot here
             }
         } catch (ClassCastException exc) { ....
}
}
}