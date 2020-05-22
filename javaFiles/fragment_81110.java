for (int id : remoteUsers.keys()) {
   User local;
   if (localUsers.containsKey(id)) {
      local = localUsers.get(id);
   else {
      localUsers.put(id, local = new User(id));
   }
   local.updateFrom(remoteUsers.get(id));
}