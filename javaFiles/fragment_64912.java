public class FamilyWaiterThread implements Runnable {
    private FamilyGroup group;
    private boolean hasSomthingNew = true;
    private final long MAX_WAITING_TIME = 1000 * 10;
    private final long MAX_INACTIVE_TIME = 1000 * 3;

    FamilyWaiterThread(FamilyGroup group) {
        this.group = group;
    }

    public boolean hasSomethingNew() {
        return hasSomthingNew;
    }

    public void setHasSomethingnew(boolean value) {
        hasSomthingNew = value;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (!timeOut(startTime) && hasSomethingNew()) {
            hasSomthingNew = false;
            long currentTime = System.currentTimeMillis();
            if (((startTime + MAX_WAITING_TIME) - currentTime) < MAX_INACTIVE_TIME) {
                break;
            }
            try {
                Thread.sleep(MAX_INACTIVE_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long afterWhileLoop = System.currentTimeMillis();
        System.out.println("Total waiting time " + (afterWhileLoop - startTime));
        group.displayFamilyMembers();
        System.out.println("__________________________________");
    }

    private boolean timeOut(long startTime) {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - startTime) > MAX_WAITING_TIME) {
            return true;
        }
        return false;
    }
}