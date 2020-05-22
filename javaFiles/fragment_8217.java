@Component
class EventSubscriber implements DisposableBean, Runnable {

    private Thread thread;
    private volatile boolean someCondition;

    EventSubscriber(){
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run(){
        while(someCondition){
            doStuff();
        }
    }

    @Override
    public void destroy(){
        someCondition = false;
    }

}