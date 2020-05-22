private void ParentFunc {
    WorkerClass worker = new WorkerClass();

    worker.doWork(new Callback<Integer>() {
        public void invoke(Integer arg) {
            System.out.println("Progress" + arg);
        }
    });
}

public class WorkerClass {
    public doWork(Callback<Integer> callback) {
        for (int i=1; i<1000; i++) callback.invoke(i);  
    }
}

public interface Callback<T> {
    public void invoke(T arg);
}