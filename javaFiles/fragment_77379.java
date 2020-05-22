private WaitTask waitTask;

public void setWaitTask(WaitTask task){
    this.waitTask = task;
}

[...]

// IPv4 found
    if (ipListener != null) {
        ipListener.onIpFound(m.group(0));
        // wait again until the wait task is safe to be accesed
        synchronized(waitTask){
            // increment it's value
            waitTask.increment();
            // notify that we changed the value
            waitTask.notify();
        }

    }
[...]