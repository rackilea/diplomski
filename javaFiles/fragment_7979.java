// **** make this final
final JButton btnCloseWindow = new JButton("Close ALT+X"); // ***

// ....

btnCloseWindow.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        // JFrame frame = new JFrame();  // **** get rid of this ****

        // ***** note change? We're using btnCloseWindow as first param.
        int result = JOptionPane.showConfirmDialog(btnCloseWindow , 
              "Are you sure you want to close the application?", 
              "Please Confirm",JOptionPane.YES_NO_OPTION);

        // ......