public class JobDone {

   @OneToOne(fetch = FetchType.LAZY)
   public Complaint getComplaint() {
        return complaint;
    }

}