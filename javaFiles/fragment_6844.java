public class ConfDialog extends JDialog {

    public ConfDialog(JFrame parent, String title, int whidth, int eight) {
        super(parent, title, Dialog.ModalityType.APPLICATION_MODAL);

        this.setSize(new Dimension(whidth, eight));
        this.setLocation(200, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        components();
    }

    public void components() {

        //JLabels, JButtons, ecc... declarations
        final JComboBox<File> box = new JComboBox<File>(stuffInFolder);

        box.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File file = (File) box.getSelectedItem();
                if (file != null) {
                // Read file
                    // Update the fields on your UI, using things like setText 
                    // and other methods which change the output of the UI
                }
            }
        });

        //...something else...
    }

}