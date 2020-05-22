public final class MyPage extends Page {

    /**
     * Constructor
     */
    public HomePage() {
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        add(new DropZone("dropZone", 300, 200));
    }
}