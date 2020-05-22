Set<Integer> toDeactivate = new TreeSet<Integer>();
toDeactivate.addAll(localUsers.keySet());
toDeactivate.removeAll(remoteUsers.keySet());

for (int id : toDeactivate) {
   User local = localUsers.get(id);
   local.deactivate();
   localUsers.remove(id);
}