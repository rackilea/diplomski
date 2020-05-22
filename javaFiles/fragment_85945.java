List<Id> allUsersIds = allUserNodes.stream().map(n -> n.getNodeId()).collect(Collectors.toList());

for (ItemSetNode itemSetNode : itemSetNodeList)
{
    Id nodeId = itemSetNode.getNodeId();

    if (!allUsersIds.contains(nodeId))
    {
        isUserMissingNode = true;
        break;
    }
}