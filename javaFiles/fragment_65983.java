abstract class Robot implements Runnable {

}

class SampleRobot extends Robot {

    @Override
    public void run() {
        while (!Thread.interrupted()) {

        }
    }

}

class RobotRunner {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void runRobot(Robot robotToRun) throws InterruptedException, ExecutionException {
        Future<?> robotFuture = executorService.submit(robotToRun);
        try {
            robotFuture.get(5, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            // This is where you would handle the timeout occurring.
        }
    }
}