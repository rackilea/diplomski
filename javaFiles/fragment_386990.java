public class GuidedTour {
    private String tourDetails;

    public GuidedTour(String tourID, int tourSize) { // other arguments omitted for brevity
        this.tourDetails = tourID + tourSize;
    }

    public String getTourDetails() {
        return tourDetails;
    }
}