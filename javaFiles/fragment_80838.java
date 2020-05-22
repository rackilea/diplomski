public class BackgroundTask {
    private Label labelToUpdate;
    private Notification notificationToUpdate;

    public BackgroundTask(Label label) {
        this.labelToUpdate = label;
    }

    public BackgroundTask(Notification notification) {
        this.notificationToUpdate = notification;
    }

    //...
    private void reportNewStep(String step) {
        if (labelToUpdate != null) {
            labelToUpdate.setText(step);
        }
        if (notificationToUpdate != null) {
            notificationToUpdate.alert(step);
        }
    }
}