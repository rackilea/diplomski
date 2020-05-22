public class IPGUI extends JFrame implements ActionListener {

...

public IPGUI() {
        setTitle("IP Extractor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton btnConvertDocuments = new JButton("1. Convert Documents");
        btnConvertDocuments.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnConvertDocuments.setMaximumSize(new Dimension(160, 0));
        btnConvertDocuments.setPreferredSize(new Dimension(0, 50));

        panel.add(btnConvertDocuments);
        //btnConvertDocuments.addActionListener(new ActionListener() {
        //    public void actionPerformed(ActionEvent e) {
        //        //FileConverter fc = new FileConverter();
        //                    //Why wont the above method work?
        //    }
        //});

        btnConvertDocuments.setActionCommand("x");
        btnConvertDocuments.addActionListener(this);

        JSeparator separator_3 = new JSeparator();
        panel.add(separator_3);
}

public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
    if (command.equals("x")) {
        //FileConverter fc = new FileConverter();
    }
}
...

}