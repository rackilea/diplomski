class X extends Thread {

    public X() {
            super("X")
    }

    public void run(){
            try {
            ...
        }
    }

    class OtherThread extends Thread{
        Thread t;

        public OtherThread(Thread x){ // pass the X thread to this thread
            super("OtherThread");
            this.t = x;
        }

        public void run(){
            try {
            ...
        }

    }