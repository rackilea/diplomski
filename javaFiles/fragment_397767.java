} else if(sb.toString().equalsIgnoreCase("invalid:Username")) {

    b = false;

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            JOptionPane.showMessageDialog(null, "alert", "alert", 
               JOptionPane.ERROR_MESSAGE);          
        }
    });
}