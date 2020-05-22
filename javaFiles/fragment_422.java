public class Compilant {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public JobDone getJobDone() {
        return jobDone;
    }

}