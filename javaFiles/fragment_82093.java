class MessagePrinterTask implements Runnable {
    public MessagePrinterTask(ADependency aDependency){
        this.aDependency = aDependency;
    }


    private ADependency aDependency;

    public void run() {
        aDependency.doNotThrowNullPointerExceptionPlease();
    }
}