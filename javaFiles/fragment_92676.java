public class MyClass {
    private long lastDiskCheck;
    private long lastDiskRead;
    private long lastDiskWrite;

    private YourObject object;

    public void setLastDiskCheck(lastDiskCheck){ // setter of lastDiskCheck
        this.lastDiskCheck = lastDiskCheck;
    }

    public long getLastDiskCheck(){ //getter of lastDiskCheck
        return lastDiskCheck;
    }
}