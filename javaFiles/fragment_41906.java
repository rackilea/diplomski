public class DriverThread implements Runnable {
    private List<WebDriver> driverList;

    public DriverThread(List<WebDriver> driverList) {
        this.driverList = driverList;
    }

    @Override
    public void run() {
        WebDriver driver = new PhantomJSDriver();
        driverList.add(driver);
    }

    public void kill() {
        // Kill your driver here!
    }
}