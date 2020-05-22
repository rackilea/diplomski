@Stateless
public class LabbBean {

    @EJB
    WorkerEjb workerEjb;

    @Schedule(second="*/5", minute="*",hour="*", persistent=false)
    public void myMethod() {
        for (all jobs found in db){
            workerEjb.workerMethod(job);    
        }
    }
}

@Stateless
public class WorkerEjb {
    @Asynchronous
    public void workerMethod(job) {
        //Send emails
    }
}