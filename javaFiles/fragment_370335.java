if (mainGameThread .getState() == Thread.State.TERMINATED)
{

    mainGameThread = new MainGameThread(this, mainSurfaceHolder, mainContext);  
    mainGameThread.setRunning(true);
    mainGameThread.start();
}
else
{
    mainGameThread.setRunning(true);
    mainGameThread.start();
}