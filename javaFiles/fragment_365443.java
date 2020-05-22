for (Worklog worklogByIssueItem : worklogByIssue)
{
   int timeSpent = worklogByIssueItem.getTimeSpent().intValue();
   String worklogAuthorName = worklogByIssueItem.getAuthorObject().getName();
   ...
}