public class MyLabel {
    JLabel label;
    String path;
    String text;

    public MyLabel(String path, String text) {
        this.label = new JLabel();
        this.path = path;
        this.text = text;      
    }
    public void setUpImage(String path) {
        this.label.setIcon(new ImageIcon(getClass().getResource(path)));
    }

    public JLabel getLabel() {
      setUpImage(this.path);
        return this.label;
    }

}