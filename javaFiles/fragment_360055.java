public class JLW_PieApplet extends JApplet {

   public void init() {
      add(new PieData());
   }

   class PieData extends JComponent {
      PieValue[] slices = new PieValue[4];

      PieData() {
         slices[0] = ...
      }

      @Override
      protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         drawPie((Graphics2D) g, getBounds(), slices);
      }

      public void drawPie(Graphics2D g, Rectangle area, PieValue[] slices) {
      ...