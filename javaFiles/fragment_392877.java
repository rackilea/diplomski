public class CustomFoodItemButton extends JButton {
    public CustomFoodItemButton(String title) {
        super(title);
        setName(title);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setSelected(false);
        setImage();
    }
}