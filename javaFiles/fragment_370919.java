import java.util.Date;
import java.util.Comparator;
import java.util.PriorityQueue;

class Job implements Runnable{

 Priority priority;
 Date dateOccurance;

 public Job(Priority priority, Date occurance){
    this.priority = priority;
    this.dateOccurance = occurance;
 }

 public void run(){
    //Job execution
    System.out.println("executed");
 }
}

enum Priority {
 High,
 Medium,
 Low
}

class JobComparator implements Comparator<Job>  {

 @Override
 public int compare(Job j1, Job j2) {

    if(j1.priority.ordinal() > j2.priority.ordinal()) {
        return 1;
    } else if (j1.priority == j2.priority) {
        if(j1.dateOccurance.after(j2.dateOccurance)) {
            return 1;
        } else if (j1.dateOccurance.before(j2.dateOccurance)) {
            return -1;
        } else {
            return 0;
        }
    }  
    return -1;
 }

}

public class PriorityQueueTest {

public static void main(String[] args) throws InterruptedException {
    Date d = new Date();
    Job job1 = new Job(Priority.High, d);
    Job job2 = new Job(Priority.High, d);
    Job job3 = new Job(Priority.Medium, d);
    Job job4 = new Job(Priority.Low, d);    
    Thread.sleep(2000);
    Date l = new Date();
    Job job5 = new Job(Priority.Low, l);    

    Comparator<Job> jComp = new JobComparator();
    PriorityQueue<Job> queue = 
        new PriorityQueue<Job>(10, jComp);

    queue.add(job4);
    queue.add(job3);
    queue.add(job1);
    queue.add(job2);
    queue.add(job5);


    while (queue.size() != 0)
    {
        Job j = queue.remove();
        System.out.println(j.priority +"     "+j.dateOccurance);
    }
 }      

}