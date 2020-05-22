import java.awt.*;
import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EnumMap;
import java.util.Map;

@SuppressWarnings("serial")
class TrafficLight3  {

   private static final int DIAMETER = 100;

   private static void createAndShowGui() {
      StopLightModel model = new StopLightModel();
      StopLightView view = new StopLightView(DIAMETER);
      new StopLightControl(view, model);

      JFrame frame = new JFrame("Traffic Light");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(view.getMainPanel());
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }

}

enum MyColor {
   RED(Color.red, "Red"),
   YELLOW(Color.yellow, "Yellow"),
   GREEN(Color.green, "Green");

   public Color getColor() {
      return color;
   }
   public String getName() {
      return name;
   }
   private MyColor(Color color, String name) {
      this.color = color;
      this.name = name;
   }
   private Color color;
   private String name;
}

class StopLightModel {
   public static final String SELECTED_COLOR = "selected color";
   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);
   private MyColor selectedColor = null;

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

   public MyColor getSelectedColor() {
      return selectedColor;
   }

   public void setSelectedColor(MyColor selectedColor) {
      MyColor oldValue = this.selectedColor;
      MyColor newValue = selectedColor;
      this.selectedColor = selectedColor;
      pcSupport.firePropertyChange(SELECTED_COLOR, oldValue, newValue);
   }

}

class StopLightControl {
   private StopLightView view;
   private StopLightModel model;

   public StopLightControl(final StopLightView view, final StopLightModel model) {
      this.view = view;
      this.model = model;
      view.setStopLightControl(this);
      model.addPropertyChangeListener(new ModelListener());
   }

   public void setSelectedColor(MyColor myColor) {
      model.setSelectedColor(myColor);
   }

   private class ModelListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (StopLightModel.SELECTED_COLOR.equals(evt.getPropertyName())) {
            MyColor myColor = model.getSelectedColor();
            view.setSelectedColor(myColor);
         }
      }
   }

}

class StopLightView {
   private JPanel mainPanel = new JPanel(new GridLayout(0, 1));
   private StopLightControl control;
   private Map<MyColor, StopLightPanel> colorPanelMap = new EnumMap<>(MyColor.class);

   public StopLightView(int diameter) {
      MouseAdapter mouseClicked = new MouseClicked();
      for (MyColor myColor : MyColor.values()) {
         StopLightPanel lightPanel = new StopLightPanel(diameter, myColor);
         lightPanel.addMouseListener(mouseClicked);
         mainPanel.add(lightPanel);
         colorPanelMap.put(myColor, lightPanel);
      }
   }

   public void setSelectedColor(MyColor myColor) {
      for (MyColor color : MyColor.values()) {
         colorPanelMap.get(color).setLightOn(color == myColor);
      }
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

   public void setStopLightControl(StopLightControl control) {
      this.control = control;
   }

   private class MouseClicked extends MouseAdapter {
      @Override
      public void mousePressed(MouseEvent mEvt) {
         if (control == null) {
            return;
         }

         StopLightPanel panel = (StopLightPanel) mEvt.getSource();
         control.setSelectedColor(panel.getMyColor());
      }
   }
}

@SuppressWarnings("serial")
class StopLightPanel extends JPanel {
   // avoid "magic" numbers
   private static final int GAP = 10;
   private int diameter;
   private MyColor myColor;
   private Color onColor;
   private Color offColor;
   private boolean lightOn;

   public boolean isLightOn() {
      return lightOn;
   }

   public void setLightOn(boolean lightOn) {
      this.lightOn = lightOn;
      repaint();
   }

   public StopLightPanel(int diameter, MyColor myColor) {
      this.diameter = diameter;
      this.myColor = myColor;
      this.onColor = myColor.getColor().brighter();
      this.offColor = myColor.getColor().darker().darker();
      this.lightOn = false;
   }

   public MyColor getMyColor() {
      return myColor;
   }

   @Override
   public Dimension getPreferredSize() {
      int prefW = diameter + 2 * GAP;
      int prefH = prefW;
      return new Dimension(prefW, prefH);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      // smooth out the edge of our circle
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      Color color = lightOn ? onColor : offColor;
      g2.setColor(color);
      g2.fillOval(GAP, GAP, diameter, diameter);
   }
}