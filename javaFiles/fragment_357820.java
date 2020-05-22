public class ZoomPane extends JPanel {

    private boolean isAutoDisplayEnabled = false;
    //...


    public void setShowZoomPopup(boolean show) {
        popup.setVisible(show);
        isAutoDisplayEnabled = show;
    }