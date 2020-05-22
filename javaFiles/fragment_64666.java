MovePanel.requestFocus();      // Give the panel focus.



public class demo extends JFrame 
{
    MovePanel  panel;

    public demo () 
    {
        panel= new MovingTextPanel();
        this.getContentPane().setLayout(new BorderLayout())
        this.setTitle("Demo");
        this.pack();
        panel.requestFocus();      // Give the panel focus.
    }
}