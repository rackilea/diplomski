public class ClientMessageHandler {

    public void onMessageReceived(JSONObject clientRequest) throws JSONException {

        // Retrieve the Method corresponding to the task from map
        Method method = taskList.get(clientRequest.getString("task"));

        if (method == null)
            return;

        try {
            // Invoke the Method for this object, if Method corresponding
            // to client request is found 

            method.invoke(this);
        } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            logger.error(e);
        }
    }

    @TaskAnnotation("task1")
    public void processTaskOne() {

    }

    @TaskAnnotation("task2")
    public void processTaskTwo() {

    }

    // Methods for different tasks, annotated with the corresponding
    // clientRequest code
}