public class Process implements Runnable{

List<Job> jobLists;

public Process(List<Job> lists) {
    this.jobLists = lists;
}

@Override
public void run() {
    System.out.println(Thread.currentThread().getName());
    while(!jobLists.isEmpty()){
        Job job = jobLists.get(0);
        job.start();
        if (job.isCompleted()){
            jobLists.remove(0);
        }else{
            System.out.println("Interrup issuesed");
            return;
        }

    }
}