import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Scheduler {
    private LinkedList<Interval> intervals = new LinkedList<Scheduler.Interval>();

    public void addTask(Runnable task, int position) {
        if(position<0){
            throw new IllegalArgumentException();
        }
        while(intervals.size() <= position){
            intervals.add(new Interval());
        }
        Interval interval = intervals.get(position);
        interval.add(task);
    }

    public void executeNextInterval(){
        Interval current = intervals.removeFirst();
        current.run();
    }
    private static class Interval {
        private List<Runnable> tasks = new ArrayList<Runnable>();
        public void add(Runnable task) {
            tasks.add(task);
        }
        public void run() {
            for (Runnable task : tasks) {
                task.run();
            }
        }
    }
}