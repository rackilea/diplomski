CustomField csUserField = ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName(fieldName);
IssueService issueService = ComponentAccessor.getIssueService();
IssueInputParameters issueInputParameters = issueService.newIssueInputParameters();
issueInputParameters.addCustomFieldValue(csUserField.getId(), value_string);
issueInputParameters.setSkipScreenCheck(true);
issueInputParameters.setRetainExistingValuesWhenParameterNotProvided(true, true);
UpdateValidationResult updateValidationResult = issueService.validateUpdate(user, issue.getId(), issueInputParameters);  
if (updateValidationResult.isValid())
{
    IssueResult updateResult = issueService.update(user, updateValidationResult);
    if (!updateResult.isValid())
    {
        log.warn("ISSUE has NOT been updated. Errors: {}\n", updateResult.getErrorCollection().toString());
    }
    else
    {
        log.warn("ISSUE has been updated.\n");
    }
}
else
{
    log.warn("ISSUE has NOT been updated. Errors: {}\n", updateResult.getErrorCollection().toString());
}