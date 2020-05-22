public class Tests {
    public static void main(String[] args) {
        for(int threadCount = 0; threadCount<5; threadCount++) {
            new Thread(new Runnable() {
                public void run() {
                    //Create a new instance of the Firefox Driver
                    capabilities=DesiredCapabilities.firefox();

                    //Let's say I have one WebDriver object for now 
                    try{
                        driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }

                    //Go to Google
                    driver.get("http://www.google.com");

                    //Quit Driver
                    driver.quit;
                }
            }).start();
        }
    }
}