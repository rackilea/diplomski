public class SecondUI extends JDialog {

    private final JPanel contentPanel = new JPanel();

    public SecondUI(OneUI oneui) {
        //setVisible(true); // don't call setvisible here call setvisible after you add all the component .
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 327, 142);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        getContentPane().add(contentPanel, BorderLayout.CENTER);
        {
            JButton btnAddOneElement = new JButton("Add 1 element");
            btnAddOneElement.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    oneui.updateModelCmb();
                }
            });
            contentPanel.add(btnAddOneElement);
        }
        setVisible(true); // call setvisible at last
    }

}