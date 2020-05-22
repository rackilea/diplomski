@Override
  public void do(WorkflowInput input) {
    Promise<List<String>> violations = activities.validate(input);
    Promise<String> whatever = processValidationResult(violations);
    processNextStep(whatever);
  }

  @Asynchronous
  private Promise<String> processValidationResult(Promise<List<String>> violations) {
    // As method is @Asynchronous framework guarantees violations is ready 
    // when its body is executed.
    if (!CollectionUtils.isEmpty(violations.get())) {
        throw new ValidationException(...);
    }
    // do other stuff
    return Promise.asPromise("result string");
  }

  @Asynchronous
  private void processNextStep(Promise<String> whatever) {
     ...
  }