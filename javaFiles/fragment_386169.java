public class ImportDataObject {
    private String kittenUrl;
    private String kittenName;
    private int numOfReviews;
    private int rating; //add getters and setters
    private List<String> categories; //add getters and setters
    public String getKittenUrl() {
        return kittenUrl;
    }
    public void setKittenUrl(String kittenUrl) {
        this.kittenUrl = kittenUrl;
    }
    public String getKittenName() {
        return kittenName;
    }
    public void setKittenName(String kittenName) {
        this.kittenName = kittenName;
    }
    public int getNumOfReviews() {
        return numOfReviews;
    }
    public void setNumOfReviews(int numOfReviews) {
        this.numOfReviews = numOfReviews;
    }

}