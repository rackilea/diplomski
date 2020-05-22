import java.util.concurrent.RecursiveAction;

public class WorkManager extends RecursiveAction{

Long from, to;
Long threshold = 10000L;

public WorkManager(Long from, Long to) {
    this.from = from;
    this.to = to;
}

protected void computeDirectly(){
    Breaker b = new Breaker(from, to);
    b.scan();
}

@Override
protected void compute() {
    if ((to - from) <= threshold){
        System.out.println("New thread from " + from + " to " + to);
        computeDirectly();
    }
    else{
        Long split = (to - from) /2;
        invokeAll(new WorkManager(from, from + split),
                new WorkManager(from + split + 1L, to));
    }
}
}