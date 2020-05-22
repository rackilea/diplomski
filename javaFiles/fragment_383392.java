public class TaskListAdapter extends XmlAdapter<TaskList, ObservableList<Task>> {

  @Override
  public ObservableList<Task> unmarshal(TaskList v) throws Exception {
    ObservableList<Task> list = FXCollections.observableArrayList(v.entries);
    return list;
  }

  @Override
  public TaskList marshal(ObservableList<Task> v) throws Exception {
    TaskList taskList = new TaskList();
    v.stream().forEach((item) -> {
      taskList.entries.add(item);
    });
    return taskList;
  }
}