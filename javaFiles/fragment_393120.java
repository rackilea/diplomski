Integer instanceState = -1;
while(instanceState != 16) { //Loop until the instance is in the "running" state.
    instanceState = getInstanceStatus(myInstanceID);
    try {
        Thread.sleep(5000);
    } catch(InterruptedException e) {}
}