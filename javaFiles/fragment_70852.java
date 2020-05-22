try {
   dialog = new MainView(new javax.swing.JFrame(), true);
   dialog.setVisible(true); //  <--- move it here
} catch (ParseException | SQLException | ClassNotFoundException ex) {
   Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
}