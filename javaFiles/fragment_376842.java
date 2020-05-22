// 'E' stands for enhanced
public class EJSlider extends JSlider {

   public EJSlider() {
      super();
      addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            Point p = e.getPoint();
            double percent = p.x / ((double) getWidth());
            int range = getMaximum() - getMinimum();
            double newVal = range * percent;
            int result = (int)(getMinimum() + newVal);
            setValue(result);
         }
      });
   }

   public static void main(String[] args) {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(new EJSlider());
      f.pack();
      f.setVisible(true);
   }
}