private static final class Params{
    final int oldStatus;
    final int newStatus;
    final String AssignTo;
    final String AssignNe;

    public Params(int oldStatus, int newStatus, String assignTo, String assignNe) {
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.AssignTo = assignTo;
        this.AssignNe = assignNe;
    }
}