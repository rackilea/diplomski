public class MazeFrame extends javax.swing.JFrame {
    Maze m;
    /**
     * Creates new form MazeFrame
     */
    public MazeFrame(Maze m) {
        this.m = m;
//  Don't manually set the size of a frame. Let the preferred size of you components determine the size. 
// This is done by invoking pack() after all components have been added to the frame.
//        setSize(new Dimension(800, 600)); 
        JPanel pan = new JPanel();
        add(pan);
//        setVisible(true); // do after all components added.
        // pan.setBackground(Color.yellow);
        pan.setLayout(new GridLayout(m.width, m.height));

        for (int curr = 0; curr < m.height; curr++){
            for (Cell c: m.maze[curr]){
                JLabel lab = new JLabel();
                lab.setOpaque(true); // as suggested by MadProgrammer
                switch (c.state){
                    case border:
                        lab.setBackground(Color.black);
                        System.out.println("addedborder");
                        break;
                    case wall:
                        lab.setBackground(Color.DARK_GRAY);
                        System.out.println("addedwall");
                        break;
                    case open: 
                        lab.setBackground(Color.LIGHT_GRAY);
                        System.out.println("addedopen");
                        break;
                    case travelled: 
                        lab.setBackground(Color.RED);             
                }
// Set the preferred size so layout managers can do there job
//                lab.setSize(new Dimension(50, 50));
                lab.setPreferredSize(new Dimension(50, 50));
// Not required. This is the default for all components except top level containers like JFrame, JDialog
//                lab.setVisible(true);               
                pan.add(lab);
                //   System.out.println("added");
            }
        }
//  No neeed to revalidate or repaint because the frame is not visible yet
//        pan.revalidate();
//        pan.repaint();
        pack(); // let the layout manager determine the size of the frame
        setVisible(); // show the frame
    }
}