public class PrintToJTA {
private final int delay = 20;
private int counter;
private javax.swing.Timer timer;
private JTextArea area;
{timer = new javax.swing.Timer(delay,getTimerAction());}

public void startPrinting (JTextArea textArea) throws InterruptedException {
       //....
       area = textArea;
       timer.start();
    }
private ActionListener getTimerAction(){
  return new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        if(++counter >= 10)
           timer.stop();
        area.appent("Hello\n");

     }
};

}