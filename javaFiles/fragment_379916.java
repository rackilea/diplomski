/**
 * Warning - this class is UNSYNCHRONIZED!
 */
public class RotatableImage {
    Image image;
    float currentDegrees;

    public RotateableImage(Image image) {
        this.image = image;
        this.currentDegrees = 0.0f;
        this.remainingDegrees = 0.0f;
    }

    public void paintOn(Graphics g) {
        //put your code to rotate the image once in here, using current degrees as your rotation
    }

    public void spin(float additionalDegrees) {
        setSpin(currentDegrees + additionalDegrees);
    }

    public void setSpin(float newDegrees) {
        currentDegrees += additionalDegrees;
        while(currentDegrees < 0f) currentDegrees += 360f;
        while(currentDegrees >= 360f) currentDegrees -= 360f;
    }

}

public class ImageSpinner implements Runnable {
    RotateableImage image;
    final float totalDegrees;
    float degrees;
    float speed; // in degrees per second
    public ImageSpinner(RotatableImage image, float degrees, float speed) {
        this.image = image;
        this.degrees = degrees;
        this.totalDegrees = degrees;
        this.speed = speed;
    }

    public void run() {
        // assume about 40 frames per second, and that the it doesn't matter if it isn't exact
        int fps = 40;
        while(Math.abs(degrees) > Math.abs(speed / fps)) { // how close is the degrees to 0? 
            float degreesToRotate = speed / fps;
            image.spin(degreesToRotate);
            degrees -= degreesToRotate;
            /* sleep will always wait at least 1000 / fps before recalcing
               but you have no guarantee that it won't take forever! If you absolutely
               require better timing, this isn't the solution for you */
            try { Thread.sleep(1000 / fps); } catch(InterruptedException e) { /* swallow */ }
        }
        image.setSpin(totalDegrees); // this might need to be 360 - totalDegrees, not sure
    }

}