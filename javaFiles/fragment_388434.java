public class GeneralRequest<E extends GeneralTask> implements Serializable {

  private final List<E> taskList;

  protected GeneralRequest(List<E> taskList) {
    this.taskList = taskList;
  }

  public boolean addTask(E newTask) {
    if(this.taskList.contains(newTask)) 
      return false;
    taskList.add(newTask);
    return true;
  }

}

public class AnnexationRequest extends GeneralRequest<AnnexationTask> {
  public AnnexationRequest(List<AnnexationTask> tal) {
    super(tal);
  }
}