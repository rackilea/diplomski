static class Monitor42{boolean isNotified=false;} 
static Monitor42 monitor = new Monitor42(); 
void myMethod() { 
    synchronized(monitor) {
        monitor.isNotified=false;
        xxx.setListener(new Listener(){ 
        public void onLoadComplete() { 
            synchronized(monitor) {
                monitor.isNotified=true;
                monitor.notify(); 
            } 
        }}); 
        if (!monitor.isNotified) monitor.wait(someTimeValueMS);
        monitor.isNotified=false;
    } 
}