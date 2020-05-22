public class DetailDialog extends JDialog
{
    public boolean approved = false;

    public DetailDialog(JFrame parent)
    {
        super(parent,"Detail Dialog",true);        // modal dialog parented to the calling frame
        JButton save = new JButton("Save");
        getContentPane().add(save);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                // Save whatever content
                approved = true;
                dispose();
            }
        });
    }
}