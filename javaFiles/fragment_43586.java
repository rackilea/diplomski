class SafeIssue(issue: Issue) {
  def original = issue
  def safeFoo = Option(issue.foo)
  // ...  You must write any of these you need
}
implicit def make_issues_safe(issue: Issue) = new SafeIssue(issue)