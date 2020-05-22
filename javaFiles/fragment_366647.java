cancelForCustomer(CustomerId id) {
  List<TaskKey> keys = db.findAllTasksOwnedByCustomer(id);
  for(TaskKey key : keys) {
    ScheduledFuture<?> f = tasks.get(key);
    if(f!=null) f.cancel();
  }
}