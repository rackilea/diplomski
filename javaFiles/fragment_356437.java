public class MazeDriver 
{
    public MazeDriver(){  
        Dungeon dungeon = new Dungeon();

        JFrame frame = new JFrame();
        frame.setTitle("Maze Game");
        frame.add(dungeon);
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TextPanel panel = new TextPanel(dungeon);
        panel.setBackground (Color.white);
        panel.setPreferredSize (new Dimension (800, 400));    

        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
        frame.pack();              
    }               
}