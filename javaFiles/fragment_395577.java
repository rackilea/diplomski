import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class RecursiveGuiUpdate extends JFrame {

    private final int SIZE = 4;
    JLabel[][] grid = new JLabel[SIZE][SIZE];

    RecursiveGuiUpdate()    {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(getGrid(), BorderLayout.NORTH);
        JButton paint = new JButton("Paint");
        paint.addActionListener(a -> updateGui());
        add(paint, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    private void updateGui() {
        new Task().execute();
    }

    private Component getGrid() {
        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));
        for(int i=0; i<=(SIZE-1); i++) {
            for(int j=0; j<=(SIZE-1); j++) {
                JLabel l = new JLabel(i+"-"+j, JLabel.CENTER);
                l.setOpaque(true);
                panel.add(l);
                grid[i][j] = l;
            }
        }
        return panel;
    }

    class Task extends SwingWorker<Void,Void> {

        @Override
        public Void doInBackground() {
            updateGui(0, 0);
            return null;
        }

        @Override
        public void done() { }

        //recursively set labels background
        void updateGui(int i, int j) {

            System.out.println(i+"-"+j);
            //set random, background color
            grid[i][j].setBackground(new Color((int)(Math.random() * 0x1000000)));

            try {
                Thread.sleep(500); //simulate long process
            } catch (InterruptedException ex) { ex.printStackTrace();}

            if((i==(SIZE-1))&&(j==(SIZE-1))) { return; }

            if(i<(SIZE-1)) {
                updateGui(++i, j);
            }else {
                i=0;
                updateGui(i, ++j);
            }
        }
    }

    public static void main(String[] args)  {
        new RecursiveGuiUpdate();
    }
}