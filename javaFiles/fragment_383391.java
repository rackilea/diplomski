public class TaskList {

  @XmlElement(name = "task")
  List<Task> entries = new ArrayList<>();

  public List<Task> getEntries() {
    return entries;
  }
}