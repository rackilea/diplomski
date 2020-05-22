package graphics;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class GraphicDev extends JFrame{

    private static final long serialVersionUID = 679207429168581441L;
    //
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 100;

    private int percent;
    private JProgressBar progress;

    public GraphicDev() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dim.width/2-FRAME_WIDTH/2, dim.height/2-FRAME_HEIGHT/2, FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        setLayout(new FlowLayout());
        //
        progress = new JProgressBar(0, 100);
        progress.setStringPainted(true);
        //
        JButton actButton = new JButton("Start!");
        actButton.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (long i = 0; i < 10000000000000L; i++) {
                            System.out.println(i);
                            if(i%200000 == 0){
                                progress.setValue(percent++);
                            }
                            if(percent >= 100){
                                break;
                            }
                        }
                        return null;
                    }

                    @Override
                    protected void done() {
                        JOptionPane.showMessageDialog(GraphicDev.this, "Done!");
                    }

                }.execute();    
            }
        });
        //
        add(actButton);
        add(progress);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GraphicDev g = new GraphicDev();
                g.setVisible(true);
            }
        });
    }
}