Map<String, Object> paramsMap = issueEvent.getParams();
for (String key : paramsMap.keySet()) {
    if (key.equals(IssueEvent.COMMENTS_PARAM_NAME)) {
        log.debug("Comments Param List Exists");
    }
}