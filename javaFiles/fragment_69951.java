public class Task implements Runnable {
    private TaskDetail taskDetail;

    public Task(TaskDetail taskDetail) {
        this.setTaskDetail(taskDetail);
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Task t = new Task(TaskDetail.CAR_WASH);
        t.taskDetail.getServiceFees(); //This is fine.
    }
}