public class ClientGui extends javax.swing.JFrame implements PropertyChangeListener
    .....
    propertyChanged(..){
      tfUserInput.setEnabled(true);
    }

     private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            client = new Client(tfHostname.getText(), Integer.parseInt(tfPort.getText()));
            client.addPropertyChangeListener(this);
            client.start();
        .....