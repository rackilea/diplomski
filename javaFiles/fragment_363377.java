SolveTimer timer = new SolveTimer(buildData);
Thread worker = new Thread(timer);
worker.start();
worker.join(10000);

long result = timer.getDuration();
if (result == -1)
{
    System.err.println("Unable to solve");
    worker.stop();
}