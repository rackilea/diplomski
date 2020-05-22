public class WorkflowImpl implements Workflow {
  ActivitiesClient activities;

  public Workflow(/*...*/) {
      // ...
  }

  @Override
  public void do(WorkflowInput input) {
    Promise<List<String>> violations = activities.validate(input);
    new Task(violations) {
       @Override
       public void  doExecute() {
         // Framework guarantees violations is ready 
         // (as it is Task constructor parameter)
         // when execute method is executed.
         if (!CollectionUtils.isEmpty(violations.get())) {
             return; // or throw ValidationException
         }
         // do other stuff
       }
    };
  }
}