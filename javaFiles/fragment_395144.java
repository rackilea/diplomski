public class MyGraphicsFun {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.add(
               new JComponent() {

                   public Dimension getPreferredSize() {
                       return new Dimension(800, 600);
                   }

                   public void paintComponent(Graphics g) {
                       Graphics2D g2 = (Graphics2D) g;
                       g2.setColor(Color.RED);
                       // Any other drawing you want...
                   }

               }
            );
        frame.setVisible(true);
    }

}