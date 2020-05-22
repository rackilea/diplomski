public class WorkflowImpl implements Workflow {
  ActivitiesClient activities;

  public Workflow(/*...*/) {
      // ...
  }

  @Override
  public void do(WorkflowInput input) {
    Promise<List<String>> violations = activities.validate(input);
    processValidationResult(violations);
  }

  @Asynchronous
  private void processValidationResult(Promise<List<String>> violations) {
    // As method is @Asynchronous framework guarantees violations is ready 
    // when its body is executed.
    if (!CollectionUtils.isEmpty(violations.get())) {
        return; // or throw ValidationException
    }
    // do other stuff
  }
}