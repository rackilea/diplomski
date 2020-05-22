public class ClientMessageHandler {

    private final HashMap<String, Runnable> taskList = new HashMap<>();

    ClientMessageHandler() {

        this.populateTaskList();
    }

    private void populateTaskList() {

        // Populate the map with client request as key
       // and the task performing objects as value

        taskList.put("action1", new Runnable() {
            @Override
            public void run() {
                // define the action to perform.
            }
        });

       //Populate map with all the tasks
    }

    public void onMessageReceived(JSONObject clientRequest) throws JSONException {

        Runnable taskToExecute = taskList.get(clientRequest.getString("task"));

        if (taskToExecute == null)
            return;

        taskToExecute.run();
    }
}