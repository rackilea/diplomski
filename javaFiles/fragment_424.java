public class Compilant {

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "complaint" cascade = CascadeType.ALL)
    public JobDone getJobDone() {
        return jobDone;
    }

}

public class JobDone {

   @OneToOne(fetch = FetchType.LAZY)
   public Complaint getComplaint() {
        return complaint;
    }

}