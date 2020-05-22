public class Log {

    private int numCompleted;
    private int totalWaitTime;
    private int totalProcessTime;

    public Log(){
        this.numCompleted = 0;
        this.totalWaitTime = 0;
        this.totalProcessTime = 0;
    }

    public Log(int numCompleted, int totalWaitTime, int totalProcessTime) {
        this.numCompleted = numCompleted;
        this.totalWaitTime = totalWaitTime;
        this.totalProcessTime = totalProcessTime;
    }

    public int getNumCompleted() {
        return numCompleted;
    } 

    public int getTotalWaitTime() {
        return totalWaitTime;
    }

    public int getTotalProcessTime() {
        return totalProcessTime;
    }

}