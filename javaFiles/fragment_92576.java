class SomeService {
  @Transactional
  public ... someMethod(...) {
    // Load the parent row using SELECT FOR UPDATE.

    // Save children.
  }
}