public class MainFrame extends JFrame
{
    private JButton details = new JButton("Add Detail");

    public MainFrame()
    {
        super("Main Frame");
        getContentPane().add(details);
        details.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                DetailDialog dlg = new DetailDialog(MainFrame.this);
                dlg.setVisible(true);
                if(dlg.approved){
                    details.setText("Edit Detail");
                }
            }
        });
    }
}