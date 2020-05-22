public void removeMember(Integer groupId, Integer memberId) {
    GroupEntity group = groupManager.getById(groupId);

    Set<MemberEntity> members = group.getMembers();

    MemberEntity member = members.stream().filter(item -> Objects.equals(memberId, item.getId())).findFirst().orElse(null);

    if (Objects.nonNull(member)) {
        if (/** here is you condition of making a decision of deletion **/) {
            members.remove(member);
            groupManager.save(group);
        } else {
            // here is an action in case of remove canceling        
        }
    }
}