import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FooMain {
   public static void main(String[] args) {
      FooNonGui nonGuiReference = new FooNonGui();
      FooGui fooGui = new FooGui(nonGuiReference);

      fooGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fooGui.pack();
      fooGui.setLocationRelativeTo(null);
      fooGui.setVisible(true);

   }
}

class FooGui extends JFrame implements ActionListener {
   private FooNonGui nonGuiVariable;
   private int counter = 0;

   public FooGui(FooNonGui nonGuiParameter) {
      super("GUI");
      this.nonGuiVariable = nonGuiParameter;
      JButton button = new JButton("Button");
      button.addActionListener(this); // I hate doing this, but for brevity's sake...
      add(button);
   }

   public void actionPerformed(ActionEvent e) {
      nonGuiVariable.nonGuiMethod(counter);
      counter++;
   }
}

class FooNonGui {
   public void nonGuiMethod(int counter) {
      System.out.print("In non-GUI method.  ");
      System.out.println("counter is " + counter);
   }
}