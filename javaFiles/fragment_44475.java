public final class SeatPlan {
    private SeatPlan(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
    }

    private int rowNum;
    private int colNum;

    //You should add getters for rowNum and colNum here
    //But I'm lazy so I did not do it for you

    public static final SeatPlan PLAN_A = new SeatPlan(10, 7);
    public static final SeatPlan PLAN_B = new SeatPlan(7, 15);
}