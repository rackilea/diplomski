import javax.swing.*;

public class Task_3 extends JFrame {
    private Button btn1, btn2, btn3;
    private Task1GUI task1Gui = new Task1GUI();

    public Task_3(){

      setLayout(new FlowLayout());

      btn1 = new Button("Enter data");
      btn1.addActionListener(this); //this refers to your current frame
      add(btn1);
      btn2 = new Button("Check who is going");
      add(btn2);
      btn3 = new Button("View costs");
      add(btn3);

      setTitle("Event Costs");
      setSize(280, 150);
      setVisible(true);

      // close the window
      addWindowListener(new WindowAdapter()
      {
      public void windowClosing(WindowEvent e)
      {
         dispose();
         System.exit(0); //calling the method is a must
      }
      });

    }
    public static void main(String[] args){
        new Task_3();
    }

    public void actionPerformed(ActionEvent e) {
        task1Gui.setVisible(true);
    }
}