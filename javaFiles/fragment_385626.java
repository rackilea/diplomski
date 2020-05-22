List<String> users = new ArrayList<String>();
List<String> groups = new ArrayList<String>();
List<IdentityLink> links = taskService.getIdentityLinksForTask(taskId);
for (IdentityLink link : links) {
    if (IdentityLinkType.CANDIDATE.equals(link.getType())) {
        String userId = link.getUserId();
        if (userId != null) {
            users.add(userId);
        }
        String groupId = link.getGroupId();
        if (groupId != null) {
            groups.add(groupId);
        }
    }
}