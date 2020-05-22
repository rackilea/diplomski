else {
        IssueResult issueResult = issueService.create(userObject, createSubTaskValidationResult)
        Issue subTask = issueResult.getIssue()
        subTaskManager.createSubTaskIssueLink(issue, subTask, user)
        log.debug("Sub-task " + subTask + " for issue " + issue + " is created");
}