class ProjectService throws NotFoundException {
  Try<DbProject> getProject(String id) {
      DbProject p = ... // some hibernate code
      if(p == null) {
          return new Try.Fail<DbProject>("Failed to create DbProject");
      }

      return new Try.Succeed<DbProject>(p);
  }
}