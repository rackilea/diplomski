Thread ty = new Thread(){
    public void run(){
            // do mail sending stuff here.
    }

    @Override
    protected void finalize() throws Throwable {
        // delete file here
    }
};
ty.start();