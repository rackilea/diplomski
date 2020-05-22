public class YourDialog extends JDialog implements ActionListener {
          protected File selectedFile=null;
          //Constructor
          public YourDialog(JFrame frame, boolean modal, String message) {
                //... create button and added to the panel
                someButton.addActionListener(new AbstractAction {
                    public void actionPerformed(ActionEvent e) {
                            final JFileChooser fc = new JFileChooser();
                            int returnVal = fc.showOpenDialog(YourDialog.this);
                            if (returnVal == JFileChooser.APPROVE_OPTION) {
                                File file = fc.getSelectedFile();

                                // HERE IS THE TRICK I GUESS !!
                                YourDialog.this.selectedFile=file;
                            }
                    }

                });
          }
    }