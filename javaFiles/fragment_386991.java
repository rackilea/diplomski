public class GuidedTour {
    private String tourID;
    private int tourSize;

    public GuidedTour(String tourID, int tourSize) { // other arguments omitted for brevity
        this.tourID = tourID;
        this.tourSize = tourSize;
    }

    public String getTourDetails() {
        return tourID + tourSize;
    }

    public void setTourSize(int newTourSize) {
        this.tourSize = newTourSize;
    }
}