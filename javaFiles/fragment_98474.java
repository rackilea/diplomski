public List<String> getGroupsForUser(String userId, List<String> groupIds, List<String> allExistingGroupIds) {
    List<String> groups = new ArrayList<String>();
    if ("ismail".equals(userId)) {
        groups.add("admin");
        groups.add("project_manager");
    }
    return groups;
}