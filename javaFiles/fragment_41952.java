public class Task {
  private TaskList taskList;
}

public class Tasklist {
  private List<Task> tasks;

  public void addTask(Task task) {
      tasks.add(task);
      task.taskList=this; // belongs to this list now
  }
  public void removeTask(Task task) {
      tasks.remove(task);
      task.taskList=null; // belongs to no tasklist
  }
}