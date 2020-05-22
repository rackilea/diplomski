public class TCPWorker {

    //Your static worker object
    private static TCPWorker worker;
    private TCPListener listener;

    //The method that activities use to access your TCPWorker object
    public static TCPWorker worker() {
        if (worker == null) {
            worker = new TCPWorker();
        }
        return worker;
    }

    //Make your constructor private, activities should only access your worker from the singleton method.
    private TCPWorker() {
        //Initialize the worker
    }

    public void setTCPListener(TCPListener listener) {
        this.listener = listener;
    }

    public void getTCPListener() {
        return this.listener;
    }

}