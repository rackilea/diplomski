import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class SwingWorkerDemo 
{
    static JButton pressMe;
    static JPanel buttonPanel;
    static String text;
    protected static JTextArea textArea = new JTextArea(25, 45);

    public SwingWorkerDemo() {
        JFrame frame = new JFrame("Main Frame");
        frame.setVisible(true);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pressMe= new JButton("Drück mich");
        buttonPanel.add(pressMe);
        frame.add(buttonPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pressMe.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                JFrame frame = new JFrame("Worker Frame");
                frame.setVisible(true);

                frame.add(textArea);
                frame.pack();

                MyTask task = new MyTask(textArea);
                task.execute();
            }
        });
    }

    static class MyTask extends SwingWorker<String, String> 
    {
        private JTextArea innerTextArea;

        public MyTask(JTextArea innerTextArea)
        {
            this.innerTextArea = innerTextArea;
        }

        @Override
        protected String doInBackground() throws Exception 
        {
            publish("First message:" + "\n");
            Thread.sleep(2000);
            publish(" no content on page 2:" + "\n");
            Thread.sleep(2000);
            publish(" no content on page 4:" + "\n");
            Thread.sleep(2000);
            publish(" no content on page 5" + "\n");
            Thread.sleep(2000);

            return "reading done";
        }

        @Override
        protected void process(List<String> chunks)
        {
            innerTextArea.append(chunks.get(chunks.size() - 1));
        }

        @Override
        public void done() 
        {
            try 
            {
               innerTextArea.append(get());
            } 
            catch (Exception e)
            {
               e.printStackTrace(System.err);
               System.out.println("error");
            }
        }

    }



    public static void main(String[] args)
    {
        new SwingWorkerDemo();
    }
}