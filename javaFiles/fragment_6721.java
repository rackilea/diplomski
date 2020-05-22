class Project {
  private Set<Job> jobs;

  public Set<Job> filterJobs(JobState state) {
    return jobs.stream().filter(j -> j.getState() == state).collect(Collectors.toSet());
  }

  public Set<Job> availableJobs() {
    return filterJobs(JobState.AVAILABLE);
  }

}