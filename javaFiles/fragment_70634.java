public static final HashMap<String, Method> taskList = new HashMap<>();

public static void main(String[] args) throws Exception {

    // Retrieves declared methods from ClientMessageHandler class 

    Method[] classMethods = ClientMessageHandler.class.getDeclaredMethods();

    for (Method method : classMethods) {            
        // We will iterate through the declared methods and look for
        // the methods annotated with our TaskAnnotation

        TaskAnnotation annot = method.getAnnotation(TaskAnnotation.class);

        if (annot != null) {                
            // if a method with TaskAnnotation is found, its annotation
            // value is mapped to that method.

            taskList.put(annot.value(), method);
        }
    }

    // Start server
}