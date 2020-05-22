public static void main(String args[]){
Task job1 = new Task("A");
Task job2 = new Task("B");
ArrayList<Runnable> jobLists = new ArrayList<>();
jobLists.add(job1);
jobLists.add(job2);
JobManager manager = new JobManager(jobLists);
manager.startWork();
try {
    Thread.sleep(150);
} catch (InterruptedException e) {
    e.printStackTrace();
}
manager.stopWork();
System.out.println("Issued Stop");