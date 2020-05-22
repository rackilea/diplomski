List<Task> tasks = Arrays.asList(
  new TaskA(), 
  new TaskB(), 
  new TaskC()
);
List<TaskResult> results = new List();

for(Task task: tasks) {
   long until = System.currentTimeMillis() + 180000L;
   TaskResult result = task.createResult();
   while(System.currentTimeMillis() < until) {
      result.add(task.call());
   }
   results.add(result);
}

return results.get(1);