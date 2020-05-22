void memberRemoved(MembershipEvent membershipEvent) {
  if (isLeader()) {
    Member removedMember = membershipEvent.getMember();
    Collection<K> keys = metadata.remove(removedMember.getUuid());
    realMap.removeAll(keys);
  }
}