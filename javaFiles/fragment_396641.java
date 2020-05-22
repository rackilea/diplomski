public class Server {
    private MyListener mListener;

    public static void setListener(MyListener listener) {
        mListener = listener;
    }

    /**
    * This is the method you should call when you get new data
    */
    private void doSomeWork() {
        int data = 0;
        // Process data
        if(mListener != null)
            mListener.a(data);
    }
}