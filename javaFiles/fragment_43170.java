public class WebElemetsPoss {
    int screenWidth;
    int screenHeight;

    public WebElemetsPoss(double screenWidth, double screenHeight) {
        this.screenWidth = (int)screenWidth;
        this.screenHeight = (int)screenHeight;
    }

    public WebElemetsPoss(DoubleLoader loader) {
        this(loader.screenWidth, this.screenHeight);
    }

    public static class DoubleLoader {
        double screenWidth;
        double screenHeight;
    }
}

....

Gson gson = new Gson();
WebElemetsPoss wep = new WebElemetsPoss(gson.fromJson(value, WebElemetsPoss.DoubleLoader.class));