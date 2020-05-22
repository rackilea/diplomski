public class AudioSlider extends JSlider {

    private Image img;

    public AudioSlider() {
        setOpaque(false);
    }

    /**
     * @return the img
     */
    public Image getImage() {
        return img;
    }

    public void setImage(Image img) {
        this.img = img;
    }
}