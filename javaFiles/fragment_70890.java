public void abort() {
    myState = TaskState.ABORTED;
}

@Override
public void run() {
    myState = TaskState.RUNNING;
    while (operations.get() != 0 && myState != TaskState.ABORTED) {
        resultText += text;
        operations.decrementAndGet();
    }
    if (myState != TaskState.ABORTED) {
        myState = TaskState.READY;
    }
}