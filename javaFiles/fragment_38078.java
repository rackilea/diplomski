checklistEntity.selectAll
  Checklist c = // one of those Checklist fetch with this function.
  // c.tasks is empty
  // c.process is empty
  List<Task> list = c.getTasks();
  // list is not empty, in this line fetch for tasks is made
  Process p = c.getProcess();
  // p is not empty, in this line fetch for process is made.