public class MyGdxGame extends ApplicationAdapter {

    int counter = 0;
    ReleaseDetector detector = new ReleaseDetector();

    public void addCounter() {
        counter++;
    }

    @Override
    public void render() { // Render Loop.
        detector.releaseListener(this);
    }
}