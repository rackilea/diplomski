class JobInstance implements Job {

String name;
boolean isCompleted;

public JobInstance(String name) {
    this.name  = name;
}


/**
 * @return the isCompleted
 */
public boolean isCompleted() {
    return isCompleted;
}


@Override
public void start() {

    System.out.println("Job "+this.name+" Started");
    try {
        Thread.sleep(10000);
        System.out.println("Job "+this.name+" Completed");
        isCompleted = true;
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        System.out.println("Interuppted.. Mark me finish / dont remove from List");
    }


}