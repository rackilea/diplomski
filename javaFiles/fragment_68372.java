private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     JFileChooser filechooser = new JFileChooser();
     int option = filechooser.showOpenDialog (this);
     if (option==JFileChooser.APPROVE_OPTION){
        String filename = filechooser.getSelectedFile().getPath();
        cajaTexto.setText(filename);
        // call main():
        MyProgram.main(new String[] { filename });
    }

public static void main(String args[]) {
            // assign file name
    final String route = args[0];
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrameConFondo jf = new EjemploJFrameConFondo();
                jf.setLocationRelativeTo(null);
                jf.setTitle("CPM");
                jf.setVisible(true);
                readfile(route);
            }
        });
    }
}