//used in saving the objects to XML

@XmlRootElement(name="tasks")
public class TaskListWrapper {

        private ObservableList<Task> task;


        @XmlJavaTypeAdapter(TaskListAdapter.class)
        public ObservableList<Task> getTasks() {
            return task;
        }

        public void setTasks(ObservableList<Task> tasks) {
            this.task = tasks;
        }

}