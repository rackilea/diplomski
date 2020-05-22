class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    private String coupon;
    ThreadDemo( String name){
        threadName = name;
        System.out.println("Creating " +  threadName );
    }
    public void run() {
        WebDriver driver2 = new FirefoxDriver();
        //Operations on website
        coupon="Something";

    }
    public String getCoupon(){
        if (coupon==null){
            return "";
        }else{
            return coupon;
        }
    }

    public void start (){
        System.out.println("Starting " +  threadName );
        if (t == null){
            t = new Thread (this, threadName);
            t.start ();
        }
    }

}