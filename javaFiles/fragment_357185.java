List<String> users = new ArrayList<String>();
List<IdentityLink> links = taskService.getIdentityLinksForTask(taskId);
for (IdentityLink link : links) {
    if (IdentityLinkType.CANDIDATE.equals(link.getType())) {
        users.add(link.getUserId());
    }
}