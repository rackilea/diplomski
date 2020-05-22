// Check if the task was completed including by an exception being thrown.
checkTask.isDone();

// Get the task result.
Integer count = checkTask.get(); // Note: this is a blocking method.

// If the task was finished by throwing an exception,
// get() method will also throw an exception.
// You can get the cause exception like this:
if (checkTask.isDone()) {
    try {
        checkTask.get();
    } catch(Exception e) {
        Exception cause = e.getCause(); // this will be your new Exception("Connection error")
    }
}

// Not recommended, but you can also cancel the task:
checkTask.cancel(mayInterruptIfRunning);