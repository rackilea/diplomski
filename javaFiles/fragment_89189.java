public class TestSwingListeners1 implements ActionListener
{

    // ...

    btOK = new JButton("AC Milan");
    btOK.setActionCommand("OK");
    btOKaddActionListener(this);

    btCancel = new JButton("Real Madrid");
    btCancel.setActionCommand("Cancel");
    btCancel.addActionListener(this);

    // ...

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("OK"))
        {
            lbl1.setText("Result: " + ++cnt1 + "X" + cnt2);
        }
        else if(e.getActionCommand().equals("Cancel"))
        {
            lbl1.setText("Result: " + cnt1 + "X" + ++cnt2);
        }
    }
}