public class GetInfo implements Runnable { 
    private final Thread tn; 

    private GetInfo() {
        this.tn = new Thread(this);
        this.tn.start();
    }

    public static GetInfo StartPointerInfo() {
        GetInfo info = new GetInfo();
        System.out.println("After start1");
        return info;
    }

    public void StopPointerInfo() {
        tn.interrupt();
    }
    ...
}