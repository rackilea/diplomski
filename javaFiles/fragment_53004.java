...

@Override
public Object beforeCommit(TransactionData data) throws Exception {
  if (containsWriteChanges(data)) {
    versionDataNode.setProperty("foo", "bar");
  }
  return null;
}

private boolean containsWriteChanges(TransactionData data) {
  return data.assignedNodeProperties().iterator().hasNext()
          || data.assignedRelationshipProperties().iterator().hasNext()
          || data.createdNodes().iterator().hasNext()
          || data.createdRelationships().iterator().hasNext()
          || data.deletedNodes().iterator().hasNext()
          || data.deletedRelationships().iterator().hasNext()
          || data.removedNodeProperties().iterator().hasNext()
          || data.removedRelationshipProperties().iterator().hasNext();
}

...