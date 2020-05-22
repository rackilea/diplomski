List<String> permissions = new 
Rank rank = getRank(player);
while (rank.hasInheritance()) {
  rank = rank.getInheritance();
  permissions.addAll(rank.getPermissions());
}