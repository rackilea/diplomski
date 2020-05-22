class GoodExample {
    private static volatile int temperature;

    //Called by some other thread than main
    public static void todaysTemperature(int temp){
        // This operation is a single operation, so you 
        // do not need compound atomicity
        temperature = temp;
    }

    public static void main(String[] args) throws Exception{
        while(true){
           Thread.sleep(2000);
           System.out.println("Today's temperature is "+temperature);
        }
    }
}