public class NewClass {

    public static void main(String[] args) {
        JFrame window = new JFrame("Furry Friends Animal Shelter");
        Toolkit tk = Toolkit.getDefaultToolkit();
        int widthScreen = ((int) tk.getScreenSize().getWidth());
        int lengthScreen = ((int) tk.getScreenSize().getWidth());
        window.setSize(widthScreen, lengthScreen);
        window.getContentPane().setBackground(Color.BLACK);
        window.add(new ScreenInitial());
        window.show(true);
    }

    public static class ScreenInitial extends JPanel {

        public ScreenInitial() {
            setLayout(new GridLayout(0, 1));
            JButton newArrival = new JButton("New Arrival");
            add(newArrival);
        }
    }
}